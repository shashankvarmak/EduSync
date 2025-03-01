package com.example.FacultyFlow.repository;

import com.example.FacultyFlow.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByDepartment(String department);
    Faculty findByEmail(String email); // Needed for faculty login
    
}
