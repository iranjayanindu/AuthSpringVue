package com.lk.veu.test.auth.controller;

import com.lk.veu.test.auth.model.User;
import com.lk.veu.test.auth.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public String hello(){
        return " Hello! ";
    }

    @PostMapping("/singup")
    public User singup(@RequestBody User user){
        return userRepository.save(user);
    }
}
