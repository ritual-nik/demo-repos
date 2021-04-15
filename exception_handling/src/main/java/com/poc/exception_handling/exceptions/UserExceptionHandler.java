package com.poc.exception_handling.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    Logger logger = LoggerFactory.getLogger(UserExceptionHandler.class);

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Void> handleUserNotFound(UserNotFoundException e) {
        logger.info(e.getMessage());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictingUserIdException.class)
    public ResponseEntity<ApiError> handleConflictingUserId(ConflictingUserIdException e) {
        logger.warn("conflicting user id:" + e.conflictingId, e);
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getLocalizedMessage());

        return new ResponseEntity<>(
                apiError,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> handleConstraintValidation(BindException e) {
        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleUnknown(Exception e) {
        logger.error(e.getMessage(), e);
        ApiError apiError = new ApiError();
        apiError.setMessage("Unknown exception"); // we can use assumed locale if we care to
        return new ResponseEntity<>(
                apiError,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
