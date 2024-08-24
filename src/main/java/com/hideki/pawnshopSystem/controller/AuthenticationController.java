package com.hideki.pawnshopSystem.controller;

import com.hideki.pawnshopSystem.dto.TokenDTO;
import com.hideki.pawnshopSystem.dto.UserRequestDTO;
import com.hideki.pawnshopSystem.service.AuthenticationService;
import com.hideki.pawnshopSystem.shared.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> register(@RequestBody UserRequestDTO userRequest){
        try{
            System.out.println("HELLO FROM INSIDE!");
            ApiResponse<TokenDTO> response = new ApiResponse<>("Successfully registered user", authenticationService.register(userRequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        catch (Exception e){
            ApiResponse<?> response = new ApiResponse<>("Error while registering new user",e.getMessage());
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(response);
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ApiResponse<?>> authenticate(@RequestBody UserRequestDTO userRequest){
        try {
            ApiResponse<TokenDTO> response = new ApiResponse<>("Successfully authenticated user", authenticationService.authenticate(userRequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        catch (Exception e){
            ApiResponse<?> response = new ApiResponse<>("Error while authenticating user",e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
