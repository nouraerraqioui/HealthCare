package com.example.healthcare.Service;

import com.example.healthcare.Repository.UserRepository;
import com.example.healthcare.model.Role;
import com.example.healthcare.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    final private UserRepository userRepository;


    public Page<User> ListerPatients(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy)
        );

        return userRepository.findByRole(Role.PATIENT, pageable);
    }
}
