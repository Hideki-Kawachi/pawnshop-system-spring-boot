package com.hideki.pawnshopSystem.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordHashService {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private static final String pepper = System.getenv("PEPPER_KEY");


//    public String hash(String password) {
//        return passwordEncoder.encode(password + pepper);
//    }
    public String hash(String password) {
        return passwordEncoder.encode(password);
    }


    public Boolean isMatching(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword,hashedPassword);
//        return passwordEncoder.matches(rawPassword + pepper,hashedPassword);
    }


    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}
