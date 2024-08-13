package com.hideki.pawnshopSystem.dto;

import com.hideki.pawnshopSystem.model.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user){
        return new UserDTO(user.idUser,
                user.getFirstName(),
                user.getMiddleName(),
                user.getLastName(),
                user.getSex(),
                user.getBirthDate(),
                user.getEmail(),
                user.getType());
    }
}
