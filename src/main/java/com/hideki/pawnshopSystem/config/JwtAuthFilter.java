package com.hideki.pawnshopSystem.config;

import com.hideki.pawnshopSystem.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private JwtService jwtService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {
//         Get the bearer token from request
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String email;

//        If no bearer token...pass to filter chain
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

//        if it has bearer token
//        index is 7 because of the number of characters in "Bearer "
        jwt = authHeader.substring(7);
         // todo extract email from JWT token
        email = jwtService.extractUsernameEmail(jwt);

    }
}
