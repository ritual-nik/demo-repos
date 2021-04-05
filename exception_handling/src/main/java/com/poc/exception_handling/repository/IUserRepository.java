package com.poc.exception_handling.repository;

import com.poc.exception_handling.model.User;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRepository {

    User getUser(UUID id);

    User createUser(User user);
}
