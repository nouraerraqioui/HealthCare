package com.example.healthcare.Mapper;

import com.example.healthcare.DTO.UserRequestDTO;
import com.example.healthcare.DTO.AuthResponse;
import com.example.healthcare.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface UserMapper {
     User toEntity(UserRequestDTO userDTO);
     AuthResponse toDTO(User user);

}
