package com.hideki.pawnshopSystem.dto;

import com.hideki.pawnshopSystem.enums.Sex;
import com.hideki.pawnshopSystem.enums.UserType;

import java.time.LocalDate;

public record UserDTO(
        Integer idUser,
        String firstName,
        String middleName,
        String lastName,
        Sex sex,
        LocalDate birthDate,
        String email,
        UserType type
) {
}
