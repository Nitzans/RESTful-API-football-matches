package com.minutemedia.assignment.exceptions;

public class InvalidStatusException extends Exception {

    private String errorMessage=null;

    public InvalidStatusException(String errorMessage) {
        super(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}