package com.hideki.pawnshopSystem.dto;

public class TokenDTO {
    private String token;

    public TokenDTO(String jwtToken) {
        this.token = jwtToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
