package com.projectthree.springbanking.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.swing.*;
import javax.xml.ws.Response;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class SpringBankingExceptionHandler {

    @ExceptionHandler(value = {SpringBankingAPIException.class})
    public ResponseEntity<Object> handleSpringBankingAPIException(SpringBankingAPIException e) {
        // for 400 bad request
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        SpringBankingException springBankingException = new SpringBankingException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        // return response entity
        return new ResponseEntity<>(springBankingException, badRequest);

    }

    // for 500 bad request
    @ExceptionHandler(value = {SpringBankingServerException.class})
    public ResponseEntity<Object> handleSpringBankingServerException(SpringBankingServerException e) {
        HttpStatus badServerRequest = HttpStatus.INTERNAL_SERVER_ERROR;
        SpringBankingException springBankingException = new SpringBankingException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(springBankingException, badServerRequest);
    }

    // handles empty values
    // 400 bad request
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException e) {
        SpringBankingException springBankingException = new SpringBankingException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(springBankingException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        SpringBankingException springBankingException = new SpringBankingException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(springBankingException, badRequest);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        SpringBankingException springBankingException = new SpringBankingException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(springBankingException, badRequest);
    }
}
