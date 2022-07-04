package com.jecrc.cheggbookmanagement.controller;

import com.jecrc.cheggbookmanagement.model.entities.Author;
import com.jecrc.cheggbookmanagement.model.entities.Books;
import com.jecrc.cheggbookmanagement.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RestController
@Slf4j
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping(value="/author",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Books>> getWrittenBook(@RequestParam(name="authorId")Integer id){
        log.info("-------request coming for get list of book witten--------{}",id);
        return new ResponseEntity<>(authorService.getBookList(id), HttpStatus.OK);
    }
}
