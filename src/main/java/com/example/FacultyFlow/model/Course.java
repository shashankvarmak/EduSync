package com.example.FacultyFlow.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String courseCode;
    private String department; // Department offering the course

    @ManyToMany(mappedBy = "courses")
    private List<Faculty> facultyList;  // Faculties teaching this course

    // Constructors
    public Course() {}

    public Course(String courseName, String courseCode, String department) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.department = department;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public List<Faculty> getFacultyList() { return facultyList; }
    public void setFacultyList(List<Faculty> facultyList) { this.facultyList = facultyList; }
}