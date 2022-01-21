package com.projectthree.springbanking.exception;

public class SpringBankingAPIException extends RuntimeException {

    public SpringBankingAPIException(String message) {
        super(message);
    }

    public SpringBankingAPIException(String message, Throwable cause) {
        super(message, cause);
    }

}
