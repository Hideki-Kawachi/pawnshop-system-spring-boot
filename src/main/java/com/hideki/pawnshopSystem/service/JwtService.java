package com.hideki.pawnshopSystem.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Autowired
    private Environment env;


    public String extractUsernameEmail(String jwtToken) {
        return extractClaim(jwtToken, Claims::getSubject);
    }


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


    public <T> T extractClaim(String token, Function<Claims, T> claimMapper){
        final Claims claims = extractAllClaims(token);
        return claimMapper.apply(claims);
    }


    public SecretKey getSignInKey() {
        final String secretKey = env.getProperty("jwt.secret-key");
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() * 60))
                .signWith(getSignInKey())
                .compact();
    }


    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }


    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String extractedEmail = extractUsernameEmail(token);
        return (extractedEmail.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }


    public boolean isTokenExpired(String token){
        Date expirationDate = extractClaim(token, Claims::getExpiration);
        return (expirationDate.before(new Date()));
    }


}
