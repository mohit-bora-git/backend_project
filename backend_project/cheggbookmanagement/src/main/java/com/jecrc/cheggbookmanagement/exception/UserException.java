package com.jecrc.cheggbookmanagement.exception;


import com.jecrc.cheggbookmanagement.model.entities.ExceptionCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserException extends RuntimeException {

    ExceptionCode exceptionCode;
    public UserException(ExceptionCode exceptionCode) {
        super(exceptionCode.getExceptionMessage());
        this.exceptionCode = exceptionCode;
    }
}
