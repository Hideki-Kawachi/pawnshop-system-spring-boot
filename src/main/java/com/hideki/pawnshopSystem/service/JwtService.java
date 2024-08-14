package com.hideki.pawnshopSystem.service;

import com.hideki.pawnshopSystem.dto.UserRequestDTO;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.util.Map;
import java.util.function.Function;

public interface JwtService {
    public String extractUsernameEmail(String jwtToken);
    public Claims extractAllClaims(String jwtToken);
    public <T> T extractClaim(String token, Function<Claims, T> claimMapper);
    public SecretKey getSignInKey();
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);
    public String generateToken(UserDetails userDetails);
    public boolean isTokenValid(String token, UserDetails userDetails);
    public boolean isTokenExpired(String token);
}
