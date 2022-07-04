package com.jecrc.cheggbookmanagement.common;


import com.jecrc.cheggbookmanagement.model.entities.ExceptionCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseInfo{

//    T data;
//    ResultStatusCode resultStatusCode;
    String statusCode;
    String exceptionMessage;

    public ResponseInfo(ExceptionCode exceptionCode){
        statusCode=exceptionCode.getStatusCode();
        exceptionMessage=exceptionCode.getExceptionMessage();
    }
//    enum ResultStatusCode{
//        SUCCESS,
//        FAILURE
//    }
}
