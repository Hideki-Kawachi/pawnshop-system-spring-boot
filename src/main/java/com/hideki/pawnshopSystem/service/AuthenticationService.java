package com.hideki.pawnshopSystem.service;

import com.hideki.pawnshopSystem.dto.TokenDTO;
import com.hideki.pawnshopSystem.dto.UserRequestDTO;
import com.hideki.pawnshopSystem.model.User;
import com.hideki.pawnshopSystem.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService{


//    instead of autowired, do constructor based injection
    private final PasswordHashService passwordHashService;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(PasswordHashService passwordHashService, UserRepository userRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.passwordHashService = passwordHashService;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }



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
