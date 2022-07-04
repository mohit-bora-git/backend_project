package com.jecrc.cheggbookmanagement.service;

import com.jecrc.cheggbookmanagement.exception.BookException;
import com.jecrc.cheggbookmanagement.model.entities.Author;
import com.jecrc.cheggbookmanagement.model.entities.Books;
import com.jecrc.cheggbookmanagement.model.entities.ExceptionCode;
import com.jecrc.cheggbookmanagement.model.requests.CreateBookRequestDto;
import com.jecrc.cheggbookmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    AuthorService authorService;


    @Autowired
    BookRepository bookRepository;
    @Override
    public Books createBook(CreateBookRequestDto createBookRequestDto) {
        Books books =createBookRequestDto.toBook();

        Optional<Books>existingBook=bookRepository.findByIsbn(books.getIsbn());
        if(existingBook.isPresent()){
            throw new BookException(ExceptionCode.CHEGG_02);
        }
        try {
            Optional<Author> existingAuthor = authorService.findByEmail(books.getAuthor().getEmail());
            if(existingAuthor.isEmpty()) {
                Author author = authorService.saveOrUpdateBook(books.getAuthor());
                books.setAuthor(author);
            } else {
                books.setAuthor(existingAuthor.get());
            }
        } catch (Exception e){
            throw new BookException(ExceptionCode.CHEGG_03);
        }
        return bookRepository.save(books);
    }

    @Override
    public List<Books> getAllBook() {
        return bookRepository.findAll();
    }


    @Override
    public Optional<List<Books>> getBookByName(String name){
        Optional<List<Books>>bookList=bookRepository.findByName(name);
        if(bookList.isEmpty()){
            throw new BookException(ExceptionCode.CHEGG_01);
        }
        return bookList;
    }

}
