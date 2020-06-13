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

        User createdUser = new User(user.getName(),user.getGender(),user.isDeleted());
        usersDatabase.add(createdUser);
        return createdUser;
    }

    @Override
    public Optional<User> getUserById(UUID id) {

        Optional<User> tempUer = usersDatabase
                .stream()
                .filter(
                        user -> user.getUuid().equals(id)
                ).findFirst();

//        return null;
        if(tempUer.isPresent()){
            User user = tempUer.get();
            if(user.isDeleted() == false)
                return tempUer;
        }

        return null;
    }

    @Override
    public boolean deleteUserById(UUID id) {
            Optional<User> tempUser = usersDatabase.stream().filter(
                    user -> user.getUuid().equals(id)
            ).findFirst();
            if(tempUser.isPresent()){
                User user = tempUser.get();
                user.setDeleted(true);
                return true;
            }
        return false;
    }

    @Override
    public User updateUserById(UUID id, User newUser) {
        Optional<User> tempUser = usersDatabase.stream().filter(
                user -> user.getUuid().equals(id)
        ).findFirst();

        if(tempUser.isPresent() && !tempUser.get().isDeleted()){

            User user = tempUser.get();
//            System.out.println(user);
            user.setName(newUser.getName());
            user.setGender(newUser.getGender());
            user.setDeleted(newUser.isDeleted());

            return user;
        }

        return null;
    }
}
