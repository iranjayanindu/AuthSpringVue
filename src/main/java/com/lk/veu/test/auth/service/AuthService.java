package com.lk.veu.test.auth.service;

import com.lk.veu.test.auth.model.User;

import java.util.Optional;


public interface AuthService {
    User signup(User user);


    Optional<User> login(String email, String password);
}
