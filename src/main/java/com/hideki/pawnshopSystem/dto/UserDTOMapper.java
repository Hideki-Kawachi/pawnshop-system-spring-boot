package com.hideki.pawnshopSystem.dto;

import com.hideki.pawnshopSystem.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<AppUser, UserDTO> {
    @Override
    public UserDTO apply(AppUser user) {
        return new UserDTO(user.idAppUser,
                user.getFirstName(),
                user.getMiddleName(),
                user.getLastName(),
                user.getSex(),
                user.getBirthDate(),
                user.getEmail(),
                user.getType());
    }
}
