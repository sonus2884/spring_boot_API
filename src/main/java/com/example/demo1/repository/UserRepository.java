package com.example.demo1.repository;

import com.example.demo1.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    User creatUser(User user);

    Optional<User> getUserById(UUID id);
}
