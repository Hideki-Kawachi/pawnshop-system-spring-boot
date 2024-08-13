package com.hideki.pawnshopSystem.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordHashServiceImpl implements PasswordHashService {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String hash(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public Boolean isMatching(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword,hashedPassword);
    }
}
