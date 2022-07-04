//package com.jecrc.cheggbookmanagement.common;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component("responseMapper")
//public class ResponseGenerator<T> {
//
//    @Autowired
//    Gson gson;
//
//    public ResponseEntity<String> generateResponse(T data, HttpStatus httpStatus){
//
//        ResponseInfo responseInfo = new ResponseInfo();
//        return new ResponseEntity<>(gson.toJsonTree(responseInfo).toString(),httpStatus);
//    }
//}
