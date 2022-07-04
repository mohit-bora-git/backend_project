package com.jecrc.cheggbookmanagement.controller;


import com.jecrc.cheggbookmanagement.model.entities.UserInfo;
import com.jecrc.cheggbookmanagement.model.requests.CreateUserRequestDto;
import com.jecrc.cheggbookmanagement.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class UserController {


    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> createUser(@Valid @RequestBody CreateUserRequestDto createUserRequestDto){
        log.info("***************incoming of request************* {}",createUserRequestDto);
        return new ResponseEntity<>(userServiceImpl.createUserInfo(createUserRequestDto), HttpStatus.CREATED);
    }


    @GetMapping(value = "/users",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserInfo>> fetchAllUser(){
        log.info("********** get fetching request *************");
        return new ResponseEntity<>(userServiceImpl.fetchAllUser(),HttpStatus.OK);
    }

    @GetMapping(value="/user",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<UserInfo> >getUserById(@RequestParam(name="userId") Integer userId){
        log.info("id to get-------{}",userId);
        return new ResponseEntity<>(userServiceImpl.fetchUserById(userId),HttpStatus.OK);
    }
}
