package com.example.FacultyFlow.service;

import com.example.FacultyFlow.model.FacultySchedule;
import com.example.FacultyFlow.repository.FacultyScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyScheduleService {

    @Autowired
    private FacultyScheduleRepository facultyScheduleRepository;

    public List<FacultySchedule> getScheduleByFaculty(Long facultyId) {
        return facultyScheduleRepository.findByFacultyId(facultyId);
    }

    public List<FacultySchedule> getScheduleByDay(String day) {
        return facultyScheduleRepository.findByDay(day);
    }
}

