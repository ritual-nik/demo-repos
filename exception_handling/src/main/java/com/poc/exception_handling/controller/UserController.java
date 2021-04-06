package com.poc.exception_handling.controller;

import com.poc.exception_handling.model.User;
import com.poc.exception_handling.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import javax.naming.InvalidNameException;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable UUID id) {
        final User result = userService.getUser(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) throws InvalidNameException {
        final User result = userService.createUser(user);
        return ResponseEntity.ok(result);
    }

}
