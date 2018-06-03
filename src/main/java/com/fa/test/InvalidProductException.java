package com.fa.test;

public class InvalidProductException extends IllegalArgumentException {

    public InvalidProductException(String message) {
        super(message);
    }
}
