package com.example.pizzaservice.exception;

public class InvalidPhoneNumberException extends RuntimeException{
    public InvalidPhoneNumberException(String errorMessage, Throwable err) {
            super(errorMessage, err);
        }

    public InvalidPhoneNumberException(String errorMessage) {

    }
}
