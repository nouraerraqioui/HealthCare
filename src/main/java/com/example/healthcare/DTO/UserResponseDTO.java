package com.example.healthcare.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDTO {

    private Long id;
    private String username;
    private String email;
    private String token;

}
