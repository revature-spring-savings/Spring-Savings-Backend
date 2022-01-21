package com.projectthree.springbanking.exception;

public class SpringBankingServerException extends RuntimeException {

    public SpringBankingServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpringBankingServerException(String message) {
        super(message);
    }
}
