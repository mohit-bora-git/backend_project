package com.jecrc.cheggbookmanagement.controller;

import com.jecrc.cheggbookmanagement.model.entities.Books;
import com.jecrc.cheggbookmanagement.model.requests.CreateBookRequestDto;
import com.jecrc.cheggbookmanagement.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
public class BookController {


    @Autowired
    BookService bookService;

    /**
     * -------*******POST METHOD*******--------
     */

    @PostMapping(value = "/book",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Books> createBook(@RequestBody CreateBookRequestDto createBookRequestDto){
        log.info("request coming---------to create book {}",createBookRequestDto);
        return new ResponseEntity<>(bookService.createBook(createBookRequestDto),HttpStatus.CREATED);
    }


    @GetMapping(value = "/book",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Books>> getAllBook(){
        log.info("request coming--------to get all book-------");
        return new ResponseEntity<>(bookService.getAllBook(),HttpStatus.OK);
    }

}
