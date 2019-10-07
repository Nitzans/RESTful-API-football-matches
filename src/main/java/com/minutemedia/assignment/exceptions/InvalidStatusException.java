package com.minutemedia.assignment.exceptions;

public class InvalidStatusException extends Exception {

    private String errorMessage;

    public InvalidStatusException() {
        super();
        errorMessage = "Invalid match status. Only 'upcoming' or 'played' are acceptable.";
    }

    String getErrorMessage() {
        return errorMessage;
    }
}