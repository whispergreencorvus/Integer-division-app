package com.hartmanmark.inteherdivision.exception;

@SuppressWarnings("serial")
public class DividendIsLessThanDivisorException extends Exception {

    public DividendIsLessThanDivisorException(String message) {
        super(message);
    }
}
