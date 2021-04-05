package com.poc.exception_handling.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User does not exist");
    }
}
