package com.poc.exception_handling.exceptions;

public class ConflictingUserIdException extends RuntimeException {

    public ConflictingUserIdException() {
        super("User id already exists");
    }
}
