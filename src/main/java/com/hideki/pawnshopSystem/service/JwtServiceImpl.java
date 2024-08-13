package com.hideki.pawnshopSystem.service;

import com.hideki.pawnshopSystem.dto.UserRequestDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService{
    @Autowired
    private Environment env;

    @Override
    public String extractUsernameEmail(String jwtToken) {
        return extractClaim(jwtToken, Claims::getSubject);
    }

    @Override
    public Claims extractAllClaims(String jwtToken){
        try{
            return Jwts
                    .parser()
                    .clockSkewSeconds(3 * 60)
                    .verifyWith(getSignInKey())
                    .build()
                    .parseSignedClaims(jwtToken)
                    .getPayload();
        }
        catch (JwtException e){
            System.out.println("Error extracting all claims");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <T> T extractClaim(String token, Function<Claims, T> claimMapper){
        final Claims claims = extractAllClaims(token);
        return claimMapper.apply(claims);
    }

    @Override
    public SecretKey getSignInKey() {
        final String secretKey = env.getProperty("jwt.secret-key");
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String generateToken(Map<String, Object> extraClaims, UserRequestDTO userRequest) {
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(userRequest.email())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() * 60))
                .signWith(getSignInKey())
                .compact();
    }

    @Override
    public String generateToken(UserRequestDTO userRequest) {
        return generateToken(new HashMap<>(), userRequest);
    }

    @Override
    public boolean isTokenValid(String token, UserRequestDTO userRequestDTO) {
        final String extractedEmail = extractUsernameEmail(token);
        return (extractedEmail.equals(userRequestDTO.email())) && !isTokenExpired(token);
    }

    @Override
    public boolean isTokenExpired(String token){
        Date expirationDate = extractClaim(token, Claims::getExpiration);
        return (expirationDate.before(new Date()));
    }


}
