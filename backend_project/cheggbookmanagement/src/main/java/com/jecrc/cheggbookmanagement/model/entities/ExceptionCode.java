package com.jecrc.cheggbookmanagement.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ExceptionCode {
    CHEGG_01("BNF_01","book not found",HttpStatus.BAD_REQUEST),
    CHEGG_02("BAP_02","book already present",HttpStatus.BAD_REQUEST),
    CHEGG_03("CEE_03","connection error with database",HttpStatus.INTERNAL_SERVER_ERROR),
    CHEGG_04("BNA_04","book not available",HttpStatus.BAD_REQUEST),
    CHEGG_05("ONF_05","order not found",HttpStatus.BAD_REQUEST),
    CHEGG_06("UNF_06","user not found",HttpStatus.BAD_REQUEST),
    CHEGG_07("BLE","book limit exceed",HttpStatus.BAD_REQUEST);

    String statusCode;
    String exceptionMessage;
    HttpStatus httpStatus;

}
