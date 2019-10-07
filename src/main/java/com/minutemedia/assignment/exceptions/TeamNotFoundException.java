package com.minutemedia.assignment.exceptions;

public class TeamNotFoundException extends Exception {

    private String errorMessage;

    public TeamNotFoundException() {
        super();
        errorMessage = "Team name does not exist";
    }

    String getErrorMessage() {
        return errorMessage;
    }
}