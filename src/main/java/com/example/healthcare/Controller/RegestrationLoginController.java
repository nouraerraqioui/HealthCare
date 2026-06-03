package com.example.healthcare.Controller;

import com.example.healthcare.DTO.LoginRequest;
import com.example.healthcare.DTO.UserRequestDTO;
import com.example.healthcare.DTO.AuthResponse;
import com.example.healthcare.Service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class RegestrationLoginController {

    private final AuthService authService;

    public RegestrationLoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        return authService.register(userRequestDTO);
    }

    @PostMapping("/login")
    public AuthResponse loginUser(@RequestBody LoginRequest dto) {

        return authService.login(dto);
    }
}