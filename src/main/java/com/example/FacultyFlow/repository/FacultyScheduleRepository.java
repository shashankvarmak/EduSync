package com.example.FacultyFlow.repository;
import com.example.FacultyFlow.model.FacultySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyScheduleRepository extends JpaRepository<FacultySchedule, Long> {
    List<FacultySchedule> findByFacultyId(Long facultyId);
    List<FacultySchedule> findByDay(String day);
}
