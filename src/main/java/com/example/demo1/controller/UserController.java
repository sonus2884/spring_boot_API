package com.example.demo1.controller;

import com.example.demo1.dto.ResponseDto;
import com.example.demo1.models.User;
import com.example.demo1.service.UserService;
import com.example.demo1.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(Constants.HEADER_URL)
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService){

        this.userService = userService;
    }

    @PostMapping
    public User creatUser(@RequestBody User user){

        return userService.creatUser(user);
    }
    @GetMapping("/{id}")
    public ResponseDto<User> getUser(@PathVariable(name = "id") UUID id){
        Optional<User> serviceResponse = userService.getUser(id);

        if(serviceResponse == null){

            return new ResponseDto(HttpStatus.NOT_FOUND, serviceResponse);
        }
        return new ResponseDto(HttpStatus.FOUND, userService.getUser(id));
    }
    @PutMapping("/{id}")
    public User updateUserById(@PathVariable(name = "id") UUID id, @RequestBody User user){

        if(userService !=null)
            userService.updateUserById(id,user);
        return null;

    }

    @DeleteMapping("/{id}")
    public boolean deleteUerById(@PathVariable(name = "id") UUID id){

        return userService.deleteUserById(id);
    }
}
