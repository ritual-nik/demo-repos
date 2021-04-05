package com.poc.exception_handling.service;

import com.poc.exception_handling.model.User;
import com.poc.exception_handling.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User getUser(final UUID id) {
        return userRepository.getUser(id);
    }

    public User createUser(final User user) {
        return userRepository.createUser(user);
    }
}
