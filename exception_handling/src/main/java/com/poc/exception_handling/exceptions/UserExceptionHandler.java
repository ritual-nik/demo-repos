package com.poc.exception_handling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException e) {
        return new ResponseEntity<>(
                "User not found",
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictingUserIdException.class)
    public ResponseEntity<String> handleUserNotFound(ConflictingUserIdException e) {
        return new ResponseEntity<>(
                "User id already exists",
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUserNotFound(Exception e) {
        return new ResponseEntity<>(
                "Unknown exception",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
