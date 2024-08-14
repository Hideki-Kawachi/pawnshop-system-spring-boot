package com.hideki.pawnshopSystem.service;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface PasswordHashService {
    public String hash(String password);
    public Boolean isMatching(String rawPassword, String hashedPassword);
    public PasswordEncoder getPasswordEncoder();
}
