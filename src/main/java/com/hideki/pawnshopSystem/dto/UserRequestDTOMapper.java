package com.hideki.pawnshopSystem.dto;

import com.hideki.pawnshopSystem.model.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserRequestDTOMapper implements Function<User, UserRequestDTO> {
    @Override
    public UserRequestDTO apply(User user){
        return new UserRequestDTO(user.idUser,
                user.getFirstName(),
                user.getMiddleName(),
                user.getLastName(),
                user.getSex(),
                user.getBirthDate(),
                user.getEmail(),
                user.getPassword(),
                user.getType());
    }
}
