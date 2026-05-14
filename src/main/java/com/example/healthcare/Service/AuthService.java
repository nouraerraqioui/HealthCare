package com.example.healthcare.Service;

import com.example.healthcare.Configuration.JwtUtils;
import com.example.healthcare.DTO.AuthResponse;
import com.example.healthcare.DTO.LoginRequest;
import com.example.healthcare.DTO.UserRequestDTO;
import com.example.healthcare.DTO.UserResponseDTO;
import com.example.healthcare.Mapper.UserMapper;
import com.example.healthcare.Repository.UserRepository;
import com.example.healthcare.model.User;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

  public UserResponseDTO register(UserRequestDTO userRequestDTO){
      if(userRepository.findByUsername(userRequestDTO.getUsername()).isPresent()){

            throw new RuntimeException("Username déjà exists");
        }

        if(userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()){
            throw new RuntimeException("Email déjà exists");}

        User user = userMapper.toEntity(userRequestDTO);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));

      userRepository.save(user);

        return userMapper.toDTO(userRepository.save(user));
    }

    public AuthResponse login(LoginRequest dto){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

        String token = jwtUtils.generateToken(dto.getUsername());
        return new AuthResponse(token);
    }
}