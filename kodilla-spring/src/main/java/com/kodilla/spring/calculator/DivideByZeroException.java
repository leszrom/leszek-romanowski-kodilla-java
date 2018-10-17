package com.kodilla.spring.calculator;

public class DivideByZeroException extends Exception {
    public DivideByZeroException(final String message) {
        super(message);
    }
}
