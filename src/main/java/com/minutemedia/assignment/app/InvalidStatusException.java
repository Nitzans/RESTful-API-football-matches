package com.minutemedia.assignment.app;

public class InvalidStatusException extends Exception {

    public InvalidStatusException(String errorMsg){
        super(errorMsg);
    }
}
