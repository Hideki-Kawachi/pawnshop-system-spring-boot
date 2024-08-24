package com.hideki.pawnshopSystem.service;

import com.hideki.pawnshopSystem.dto.UserDTO;
import com.hideki.pawnshopSystem.dto.UserDTOMapper;
import com.hideki.pawnshopSystem.enums.Sex;
import com.hideki.pawnshopSystem.enums.UserType;
import com.hideki.pawnshopSystem.model.User;
import com.hideki.pawnshopSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordHashService passwordHashService;
    private UserDTOMapper userDTOMapper;

    public UserDTO createUser(String firstName, String middleName, String lastName, Sex sex, LocalDate birthDate, String email, String password, UserType type) {
        return userDTOMapper.apply(userRepository.save(new User(firstName, middleName, lastName, sex, birthDate, email, passwordHashService.hash(password),type)));
    }

}
