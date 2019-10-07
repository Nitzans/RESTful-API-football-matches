package com.minutemedia.assignment.exceptions;

public class TournamentNotFoundException extends Exception {

    private String errorMessage;

    public TournamentNotFoundException() {
        super();
        errorMessage = "Tournament name does not exist";
    }

    String getErrorMessage() {
        return errorMessage;
    }
}