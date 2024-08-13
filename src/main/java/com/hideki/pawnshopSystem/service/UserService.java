package com.hideki.pawnshopSystem.service;

import com.hideki.pawnshopSystem.dto.UserDTO;
import com.hideki.pawnshopSystem.enums.Sex;
import com.hideki.pawnshopSystem.enums.UserType;

import java.time.LocalDate;

public interface UserService {
    public UserDTO createUser(String firstName, String middleName, String lastName, Sex sex, LocalDate birthDate, String email, String password, UserType type);
}
