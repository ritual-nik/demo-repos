package com.poc.exception_handling.controller;

import com.poc.exception_handling.config.AcceptHeaderResolver;
import com.poc.exception_handling.exceptions.ConflictingUserIdException;
import com.poc.exception_handling.exceptions.UserNotFoundException;
import com.poc.exception_handling.model.User;
import com.poc.exception_handling.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;
import java.util.UUID;

import javax.naming.InvalidNameException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable UUID id, HttpServletRequest request) throws UserNotFoundException {
        final User result = userService.getUser(id, request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user, HttpServletRequest request) throws ConflictingUserIdException {
        final User result = userService.createUser(user, request);
        return ResponseEntity.ok(result);
    }

}
