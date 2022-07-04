package com.jecrc.cheggbookmanagement.service;

import com.jecrc.cheggbookmanagement.config.UserInfoConfig;
import com.jecrc.cheggbookmanagement.exception.BookException;
import com.jecrc.cheggbookmanagement.exception.OrderException;
import com.jecrc.cheggbookmanagement.exception.UserException;
import com.jecrc.cheggbookmanagement.model.entities.*;
import com.jecrc.cheggbookmanagement.model.requests.CreateOrderRequestDto;
import com.jecrc.cheggbookmanagement.model.requests.UpdateOrderRequestDto;
import com.jecrc.cheggbookmanagement.repository.BookRepository;
import com.jecrc.cheggbookmanagement.repository.OrderRepository;
import com.jecrc.cheggbookmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static com.jecrc.cheggbookmanagement.model.entities.BookStatus.AVAILABLE;
import static com.jecrc.cheggbookmanagement.model.entities.BookStatus.UNAVAILABLE;
import static com.jecrc.cheggbookmanagement.model.entities.OrderStatus.*;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserInfoConfig userInfoConfig;

    @Override
    public Orders placeOrder(Integer userId, Integer bookId) {
        /**
         * 1.validating a user
         */
        Optional<UserInfo> transactingUser=userRepository.findById(userId);
        if(transactingUser.isEmpty()){
            throw new UserException(ExceptionCode.CHEGG_06);
        }

        /**
         *2.validating a book and check the book is not issued
         */
        Optional<Books> existingBook=bookRepository.findById(bookId);
        if(existingBook.isEmpty()){
            throw new BookException(ExceptionCode.CHEGG_01);
        }
        Books bookCatlogue=existingBook.get();
        if(bookCatlogue.getBookStatus()==UNAVAILABLE){
            throw new BookException(ExceptionCode.CHEGG_04);
        }

        /**
         * 3.CHECK whether user exceeds its quota or not
         */
        if(userInfoConfig.getBookQuota()<=transactingUser.get().getIssuedBooks().size()){
            throw new BookException(ExceptionCode.CHEGG_07);
        }

        /**
         *4) Order with a pending state;
         *5) mark the book unavailable and issue that to the user
         *6) update the order with success status
         */

        Orders orders= Orders.builder()
                .orderStatus(PENDING)
                .rentCost(bookCatlogue.getRentCost())
                .orderReference(UUID.randomUUID().toString())
                .orderedBook(bookCatlogue)
                .dueDate(LocalDate.ofEpochDay(01-07-2022))
                .transactUser(transactingUser.get())
                .build();

        try{

            orderRepository.save(orders);
            bookCatlogue.setBookStatus(UNAVAILABLE);
            bookCatlogue.setUserInfo(transactingUser.get());
            bookRepository.save(bookCatlogue);

            orders.setOrderStatus(SUCCESS);
            orderRepository.save(orders);
        }
        catch(Exception e){
            bookCatlogue.setBookStatus(AVAILABLE);
            bookCatlogue.setUserInfo(null);
            bookRepository.save(bookCatlogue);

            orders.setOrderStatus(FAILED);
            orderRepository.save(orders);
        }
        return orders;
    }

    @Override
    public Orders returnOrder(Integer userId, Integer bookId) {

        Optional<UserInfo> transactingUser=userRepository.findById(userId);
        if(transactingUser.isEmpty()){
            throw new UserException(ExceptionCode.CHEGG_06);
        }

        Books books=bookRepository.findById(bookId).get();

        UserInfo userInfo=transactingUser.get();
        LocalDate duedate=null;
        for(Orders orders:userInfo.getOrdersList()){
            if(orders.getOrderedBook().getId()==bookId){
                duedate=orders.getDueDate();
                break;
            }
        }


        Orders orders= Orders.builder()
                .orderStatus(PENDING)
                .rentCost(books.getRentCost())
                .orderReference(UUID.randomUUID().toString())
                .orderedBook(books)
                .dueDate(duedate)
                .transactUser(transactingUser.get())
                .build();

        if((LocalDate.now().compareTo(duedate))>0){
           double difference=Duration.between(duedate,LocalDate.now()).toDays();
           double fine=difference*10;
           orders.setFine(fine);
        }

        try{

            orderRepository.save(orders);
            books.setBookStatus(AVAILABLE);
            books.setUserInfo(null);
            userInfo.getIssuedBooks().remove(books);
            bookRepository.save(books);

            orders.setOrderStatus(SUCCESS);
            orderRepository.save(orders);
        }
        catch(Exception e){
            books.setBookStatus(UNAVAILABLE);
            books.setUserInfo(userInfo);
            userInfo.getIssuedBooks().add(books);
            bookRepository.save(books);

            orders.setOrderStatus(FAILED);
            orderRepository.save(orders);
        }
        return orders;
    }
}
