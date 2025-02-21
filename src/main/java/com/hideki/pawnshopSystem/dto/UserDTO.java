package com.hideki.pawnshopSystem.dto;

import com.hideki.pawnshopSystem.enums.Sex;
import com.hideki.pawnshopSystem.enums.UserType;

import java.time.LocalDate;
import java.util.UUID;

public record UserDTO(
        UUID idUser,
        String firstName,
        String middleName,
        String lastName,
        Sex sex,
        LocalDate birthDate,
        String email,
        UserType type
) {
}
