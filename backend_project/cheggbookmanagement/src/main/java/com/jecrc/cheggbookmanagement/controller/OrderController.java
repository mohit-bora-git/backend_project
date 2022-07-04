package com.jecrc.cheggbookmanagement.controller;

import com.jecrc.cheggbookmanagement.model.entities.Orders;
import com.jecrc.cheggbookmanagement.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class OrderController {


    @Autowired
    OrderService orderService;


    @PostMapping(value = "/order",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> placeAnOrder(@RequestParam(name = "userId")Integer userId
            ,@RequestParam(name="bookId")Integer bookId){
        log.info("----------request for placing an order coming with userId={} and bookId={}",userId,bookId);
        return new ResponseEntity<>(orderService.placeOrder(userId,bookId),HttpStatus.CREATED);
    }

    @PostMapping(value="returnorder",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> returnOrder(@RequestParam(name="userId")Integer userId
            , @RequestParam(name = "bookId")Integer bookId){
        log.info("----------request for returning an order coming with userId={} and bookId={}",userId,bookId);
        return new ResponseEntity<>(orderService.returnOrder(userId,bookId),HttpStatus.CREATED);
    }
}
