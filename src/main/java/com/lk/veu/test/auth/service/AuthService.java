package com.lk.veu.test.auth.service;

import com.lk.veu.test.auth.model.User;
import org.springframework.stereotype.Service;


public interface AuthService {
    User signup(User user);
}
