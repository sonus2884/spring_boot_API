package com.example.demo1.repository;

import com.example.demo1.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("inMemory")
public class UserRepositoryImpl  implements UserRepository{
    private List<User> usersDatabase = new ArrayList<>();


    @Override
    public User creatUser(User user) {

        User createdUser = new User(user.getName(),user.getGender());
        usersDatabase.add(createdUser);
        return createdUser;
    }

    @Override
    public Optional<User> getUserById(UUID id) {

        return usersDatabase
                .stream()
                .filter(
                        user -> user.getUuid().equals(id)
                ).findFirst();

//        return null;
    }
}
