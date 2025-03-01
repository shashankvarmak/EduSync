package com.example.FacultyFlow.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CourseDeptService {

    private final Map<String, List<String>> departmentCourses;

    public CourseDeptService() {
        departmentCourses = new HashMap<>();

        departmentCourses.put("CSE", Arrays.asList(
                "Networks", "DBMS", "Operating Systems", "Data Structures", "Database Lab","Data Structures Lab"
        ));

        departmentCourses.put("IT", Arrays.asList(
                "Cloud Computing", "Web Tech", "AI", "Cybersecurity", "Web Lab", "Cloud Lab"
        ));

        departmentCourses.put("ECE", Arrays.asList(
                "Digital Comm", "Signals", "Embedded Systems", "VLSI", "Embedded Lab", "Circuits Lab"
        ));

        departmentCourses.put("EEE", Arrays.asList(
                "Control Systems", "Power Systems", "Machines", "Circuits", "Power Lab", "Circuits Lab"
        ));

        departmentCourses.put("CSIT", Arrays.asList(
                "OS", "Data Mining", "Algorithms", "Software Engg", "Algorithms Lab", "Software Lab"
        ));

        departmentCourses.put("CSC", Arrays.asList(
                "Machine Learning", "Cryptography", "Blockchain","Cloud Computing","IoT Lab", "Crypto Lab"
        ));

        departmentCourses.put("CSD", Arrays.asList(
                "Big Data", "Statistics", "Visualization", "Data Science", "Big Data Lab", "Data Lab"
        ));

    }

    public List<String> getCoursesByDepartment(String department) {
        return departmentCourses.getOrDefault(department, Collections.emptyList());
    }
}
