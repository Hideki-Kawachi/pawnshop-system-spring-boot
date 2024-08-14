package com.hideki.pawnshopSystem.service;

import com.hideki.pawnshopSystem.dto.TokenDTO;
import com.hideki.pawnshopSystem.dto.UserRequestDTO;
import com.hideki.pawnshopSystem.model.User;
import com.hideki.pawnshopSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private PasswordHashService passwordHashService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public TokenDTO register(UserRequestDTO userRequest) {
        User newUser = User.builder()
                .firstName(userRequest.firstName())
                .middleName(userRequest.middleName())
                .lastName(userRequest.lastName())
                .birthDate(userRequest.birthDate())
                .email(userRequest.email())
                .password(passwordHashService.hash(userRequest.password()))
                .sex(userRequest.sex())
                .type(userRequest.type())
                .build();
        userRepository.save(newUser);
        String jwtToken = jwtService.generateToken(newUser);
        return new TokenDTO(jwtToken);
    }

    @Override
    public TokenDTO authenticate(UserRequestDTO userRequestDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userRequestDTO.email(),
                userRequestDTO.password()
        ));
        User user = userRepository.findByEmail(userRequestDTO.email());
        if(user != null){
            String jwtToken = jwtService.generateToken(user);
            return new TokenDTO(jwtToken);
        }
        return null;
    }
}
