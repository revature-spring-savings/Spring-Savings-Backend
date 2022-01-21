package com.projectthree.springbanking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.ws.Response;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class SpringBankingExceptionHandler {

    @ExceptionHandler(value = {SpringBankingAPIException.class})
    public ResponseEntity<Object> handleSpringBankingAPIException(SpringBankingAPIException e) {
        // for 400 bad request
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
       SpringBankingException springBankingException = new SpringBankingException(
                e.getMessage(),
                e,
                // 400 bad request
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        // return response entity
        return new ResponseEntity<>(springBankingException, badRequest);

    }

}
