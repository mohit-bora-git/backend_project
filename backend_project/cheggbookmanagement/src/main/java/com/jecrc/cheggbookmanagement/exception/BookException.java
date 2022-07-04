package com.jecrc.cheggbookmanagement.exception;

import com.jecrc.cheggbookmanagement.model.entities.ExceptionCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookException extends RuntimeException{

    ExceptionCode statusCode;
    public BookException(ExceptionCode statusCode){
        super(statusCode.getExceptionMessage());
        this.statusCode=statusCode;
    }
}
