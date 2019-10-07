package com.minutemedia.assignment.exceptions;

public class TournamentNotFoundException extends Exception {

    private String errorMessage=null;

    public TournamentNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}