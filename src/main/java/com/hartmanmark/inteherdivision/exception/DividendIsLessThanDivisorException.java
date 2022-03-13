package com.hartmanmark.inteherdivision.exception;

public class DividendIsLessThanDivisorException extends Exception {

    private static final long serialVersionUID = 1L;

    public DividendIsLessThanDivisorException(String message) {
        super(message);
    }
}
