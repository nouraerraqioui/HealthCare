package com.example.healthcare.Repository;

import com.example.healthcare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

  public interface UserRepository extends JpaRepository<User,Long> {
        User findByEmail(String email);
}
