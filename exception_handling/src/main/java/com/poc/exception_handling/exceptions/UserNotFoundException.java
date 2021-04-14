package com.poc.exception_handling.exceptions;

public class UserNotFoundException extends ApiException {

    public UserNotFoundException(String nonLocalizedMessage) {
        super(nonLocalizedMessage);
    }
}
