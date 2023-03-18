package com.lk.veu.test.auth.controller;

import com.lk.veu.test.auth.model.User;
import com.lk.veu.test.auth.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user){
        return authService.signup(user);
    }
}
