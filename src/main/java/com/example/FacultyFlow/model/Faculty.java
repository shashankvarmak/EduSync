package com.example.FacultyFlow.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String designation;
    private String email;
    private String password;
    private String department;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacultySchedule> schedules;  // Faculty has multiple schedules

    // Constructors
    public Faculty() {}

    public Faculty(String name, String designation, String email, String password, String department) {
        this.name = name;
        this.designation = designation;
        this.email = email;
        this.password = password;
        this.department = department;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public List<FacultySchedule> getSchedules() { return schedules; }
    public void setSchedules(List<FacultySchedule> schedules) { this.schedules = schedules; }
}



