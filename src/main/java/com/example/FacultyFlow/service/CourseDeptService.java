package com.example.FacultyFlow.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CourseDeptService {

    private final Map<String, List<String>> departmentCourses;

    public CourseDeptService() {
        departmentCourses = new HashMap<>();

        departmentCourses.put("IT", Arrays.asList(
                "Data Structures", "Operating Systems", "Web Technologies", "Software Engineering", "Computer Networks",
                "Data Structures Lab", "Web Technologies Lab"
        ));
        departmentCourses.put("CSE", Arrays.asList(
                "Algorithms", "Computer Networks", "Software Engineering", "Artificial Intelligence", "Database Systems",
                "Algorithms Lab", "Database Lab"
        ));
        departmentCourses.put("CSC", Arrays.asList(
                "Database Management", "Cloud Computing", "Cyber Security", "Big Data Analytics", "Mobile Computing",
                "Cloud Computing Lab", "Cyber Security Lab"
        ));
        departmentCourses.put("CSD", Arrays.asList(
                "Machine Learning", "Big Data Analytics", "Computer Vision", "Deep Learning", "Natural Language Processing",
                "Machine Learning Lab", "Big Data Lab"
        ));
        departmentCourses.put("AIML", Arrays.asList(
                "Artificial Intelligence", "Neural Networks", "Deep Learning", "Reinforcement Learning", "AI Ethics",
                "Neural Networks Lab", "AI Programming Lab"
        ));
        departmentCourses.put("ECE", Arrays.asList(
                "Digital Circuits", "Analog Circuits", "Digital Signal Processing", "Microcontrollers", "VLSI Design",
                "Digital Circuits Lab", "Digital Signal Processing Lab"
        ));
        departmentCourses.put("EEE", Arrays.asList(
                "Power Systems", "Control Systems", "Electrical Machines", "High Voltage Engineering", "Renewable Energy Systems",
                "Power Systems Lab", "Electrical Machines Lab"
        ));
        departmentCourses.put("MECH", Arrays.asList(
                "Thermodynamics", "Fluid Mechanics", "Automobile Engineering", "Robotics", "Manufacturing Processes",
                "Thermodynamics Lab", "Fluid Mechanics Lab"
        ));
        departmentCourses.put("CSM", Arrays.asList(
                "Cryptography", "Blockchain Technology", "Ethical Hacking", "Cyber Forensics", "Digital Evidence Management",
                "Cryptography Lab", "Ethical Hacking Lab"
        ));
        departmentCourses.put("CSIT", Arrays.asList(
                "Internet of Things", "Embedded Systems", "Cloud Security", "Network Security", "Wireless Communication",
                "IoT Lab", "Embedded Systems Lab"
        ));
    }

    public List<String> getCoursesByDepartment(String department) {
        return departmentCourses.getOrDefault(department, Collections.emptyList());
    }
}
