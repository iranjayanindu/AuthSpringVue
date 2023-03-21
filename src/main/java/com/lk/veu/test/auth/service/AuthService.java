package com.lk.veu.test.auth.service;

import com.lk.veu.test.auth.config.Token;
import com.lk.veu.test.auth.model.User;

import java.util.Optional;


public interface AuthService {
    User signup(User user);


    Token login(String email, String password);
}
