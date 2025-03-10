package com.example.FacultyFlow.repository;

import com.example.FacultyFlow.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    List<LeaveRequest> findByFacultyEmail(String facultyEmail);
}
