package com.poc.exception_handling.repository;

import com.poc.exception_handling.exceptions.ConflictingUserIdException;
import com.poc.exception_handling.exceptions.UserNotFoundException;
import com.poc.exception_handling.model.User;
import org.springframework.stereotype.Repository;

import java.util.Locale;
import java.util.UUID;

@Repository
public interface IUserRepository {

    User getUser(UUID id, Locale locale) throws UserNotFoundException;

    User createUser(User user, Locale locale) throws ConflictingUserIdException;
}
