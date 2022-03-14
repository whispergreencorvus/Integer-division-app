package com.hartmanmark.inteherdivision.exception;

public class DivisorIsZeroException extends Exception{

    private static final long serialVersionUID = 1L;

    public DivisorIsZeroException(String message) {
        super(message);
    }
}
