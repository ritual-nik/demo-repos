package com.poc.exception_handling.service;

import com.poc.exception_handling.config.AcceptHeaderResolver;
import com.poc.exception_handling.exceptions.ConflictingUserIdException;
import com.poc.exception_handling.exceptions.UserNotFoundException;
import com.poc.exception_handling.model.User;
import com.poc.exception_handling.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

@Service
@AllArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    private final LocaleResolver languageResolver;

    public User getUser(final UUID id, HttpServletRequest request) throws UserNotFoundException {
        Locale locale = languageResolver.resolveLocale(request);
        return userRepository.getUser(id, locale);
    }

    public User createUser(final User user, HttpServletRequest request) throws ConflictingUserIdException {
        Locale locale = languageResolver.resolveLocale(request);
        return userRepository.createUser(user, locale);
    }
}
