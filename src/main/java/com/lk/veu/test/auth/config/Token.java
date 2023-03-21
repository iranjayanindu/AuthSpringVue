package com.lk.veu.test.auth.config;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

public class Token {
    @Getter
    private final String token;

    public Token(String token) {
        this.token = token;
    }

    public static Token of(Long userId, Long validityInMinutes, String secreteKey){
        var issueDate = Instant.now();
        return new Token(
                Jwts.builder()
                        .claim("user_id",userId)
                        .setIssuedAt(Date.from(issueDate))
                        .setExpiration(Date.from(issueDate.plus(validityInMinutes, ChronoUnit.MINUTES)))
                        .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secreteKey.getBytes(StandardCharsets.UTF_8)))
                        .compact()
        );
    }
}
