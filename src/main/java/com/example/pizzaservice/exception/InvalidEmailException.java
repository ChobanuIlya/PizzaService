package com.example.pizzaservice.exception;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public InvalidEmailException(String errorMessage){}
}
