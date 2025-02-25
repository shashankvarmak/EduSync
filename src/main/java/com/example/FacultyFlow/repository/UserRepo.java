package com.example.FacultyFlow.repository;

import com.example.FacultyFlow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
