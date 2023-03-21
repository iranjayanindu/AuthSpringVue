package com.lk.veu.test.auth.service.impl;

import com.lk.veu.test.auth.config.Token;
import com.lk.veu.test.auth.model.User;
import com.lk.veu.test.auth.repository.UserRepository;
import com.lk.veu.test.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User signup(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Token login(String email, String password) {
        Optional<User> userbyEmail = userRepository.findByEmail(email);
        if (userbyEmail.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"invalid credentials");

        if(!passwordEncoder.matches(password, userbyEmail.get().getPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"invalid credentials");
        return Token.of(userbyEmail.get().getId(),10L,"very_long_and secure_and_safe_key");
    }
}
