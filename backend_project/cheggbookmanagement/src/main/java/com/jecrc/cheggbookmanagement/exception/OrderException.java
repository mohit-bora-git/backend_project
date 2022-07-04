package com.jecrc.cheggbookmanagement.exception;

import com.jecrc.cheggbookmanagement.model.entities.ExceptionCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderException extends RuntimeException{

    ExceptionCode exceptionCode;
    public OrderException(ExceptionCode exceptionCode) {
        super(exceptionCode.getExceptionMessage());
        this.exceptionCode = exceptionCode;
    }
}
