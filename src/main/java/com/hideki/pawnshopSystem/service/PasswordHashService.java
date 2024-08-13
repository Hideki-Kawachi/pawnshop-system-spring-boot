package com.hideki.pawnshopSystem.service;

public interface PasswordHashService {
    public String hash(String password);
    public Boolean isMatching(String rawPassword, String hashedPassword);
}
