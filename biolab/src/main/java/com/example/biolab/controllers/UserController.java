package com.example.biolab.controllers;


import com.example.biolab.entities.User;
import com.example.biolab.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createUser(@RequestBody User u){
        User user = new User(u.getNome(), u.getEmail());
        userRepository.save(user);

        return user;
    }

    @GetMapping
    public List<User> showUser(){
        List<User> listarUser = userRepository.findAll();
        return listarUser;
    }

}
