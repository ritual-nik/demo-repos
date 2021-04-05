package com.poc.exception_handling.repository;

import com.poc.exception_handling.exceptions.ConflictingUserIdException;
import com.poc.exception_handling.exceptions.UserNotFoundException;
import com.poc.exception_handling.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class UserRepository implements IUserRepository {

    final HashMap<UUID, User> userMap = new HashMap<>();

    @Override
    public User getUser(UUID id) {
        if (!userMap.containsKey(id)) {
            throw new UserNotFoundException();
        }

        return userMap.get(id);
    }

    @Override
    public User createUser(final User user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }

        if (userMap.containsKey(user.getId())) {
            throw new ConflictingUserIdException();
        }

        userMap.put(user.getId(), user);
        return user;
    }
}
