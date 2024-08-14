package com.hideki.pawnshopSystem.service;


import com.hideki.pawnshopSystem.dto.TokenDTO;
import com.hideki.pawnshopSystem.dto.UserRequestDTO;

public interface AuthenticationService {
    public TokenDTO register(UserRequestDTO userRequest);
    public TokenDTO authenticate(UserRequestDTO userRequestDTO);
}
