package com.jecrc.cheggbookmanagement.controller.advice;

import com.google.gson.Gson;
import com.jecrc.cheggbookmanagement.common.ResponseInfo;
import com.jecrc.cheggbookmanagement.exception.BookException;
import com.jecrc.cheggbookmanagement.exception.BookNotFoundException;
import com.jecrc.cheggbookmanagement.exception.ConnectionErrorException;
import com.jecrc.cheggbookmanagement.model.entities.ExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalController {


    @Autowired
    Gson gson;



    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> generateBadRequestResponse(){
        return new ResponseEntity<>("bad request as Book Not Found", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConnectionErrorException.class)
    public ResponseEntity<String> generateConnectionErrorResponse(){
        return new ResponseEntity<>("ConnectionError", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookException.class)
    public ResponseEntity<String> generateExceptionResponse(BookException bookException){
        ExceptionCode exceptionCode=bookException.getStatusCode();
        ResponseInfo responseInfo=new ResponseInfo(exceptionCode);
        return new ResponseEntity<>(gson.toJsonTree(responseInfo).toString(),exceptionCode.getHttpStatus());
    }
}
