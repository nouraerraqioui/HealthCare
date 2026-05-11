package com.example.healthcare.Mapper;

import com.example.healthcare.DTO.UserRequestDTO;
import com.example.healthcare.model.User;

public interface UserMapper {
     User toEntity(UserRequestDTO userDTO);
     UserRequestDTO toDTO(User user);
}
