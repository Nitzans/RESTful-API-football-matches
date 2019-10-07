package com.minutemedia.assignment.exceptions;

public class TeamNotFoundException extends Exception {

    private String errorMessage=null;

    public TeamNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}