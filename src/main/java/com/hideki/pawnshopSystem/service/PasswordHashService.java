package com.hideki.pawnshopSystem.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordHashService {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public String hash(String password) {
        return passwordEncoder.encode(password);
    }


    public Boolean isMatching(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword,hashedPassword);
    }


    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}
