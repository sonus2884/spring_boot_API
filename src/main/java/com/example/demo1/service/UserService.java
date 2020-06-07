package com.example.demo1.service;

import com.example.demo1.models.User;
import com.example.demo1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    UserService(@Qualifier("inMemory") UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User creatUser(User user){

        return userRepository.creatUser(user);

    }

    public Optional<User> getUser(UUID id) {

        return userRepository.getUserById(id);
    }
}
