package com.example.healthcare.Controller;

import com.example.healthcare.Repository.UserRepository;
import com.example.healthcare.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegestrationLoginController {
    private final UserRepository userRepository;

    public RegestrationLoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {

        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "username already exists";
        }

        userRepository.save(user);

        return "user created successfully";
    }
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {

        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser == null) {
            return "user not found";
        }

        if (!existingUser.getPassword().equals(user.getPassword())) {
            return "invalid password";
        }

        return "login successful";
    }
    }

