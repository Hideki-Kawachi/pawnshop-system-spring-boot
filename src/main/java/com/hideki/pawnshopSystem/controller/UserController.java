package com.hideki.pawnshopSystem.controller;

import com.hideki.pawnshopSystem.dto.UserDTO;
import com.hideki.pawnshopSystem.dto.UserRequestDTO;
import com.hideki.pawnshopSystem.service.UserService;
import com.hideki.pawnshopSystem.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> add (@RequestBody UserRequestDTO userRequest){
        try {
            System.out.println("userRequest" + userRequest);
            UserDTO newUser = userService.createUser(userRequest.firstName(),
                    userRequest.middleName(),
                    userRequest.lastName(),
                    userRequest.sex(),
                    userRequest.birthDate(),
                    userRequest.email(),
                    userRequest.password(),
                    userRequest.type());
            ApiResponse<UserDTO> response = new ApiResponse<>("Successfully created new user", newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        catch (Exception e){
            ApiResponse<?> response = new ApiResponse<>("Error while creating user: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
