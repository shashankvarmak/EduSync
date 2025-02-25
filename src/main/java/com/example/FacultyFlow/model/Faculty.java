package com.example.FacultyFlow.model;

public class Faculty {
    private String name;
    private String designation;
    private String email;

    public Faculty(String name, String designation, String email) {
        this.name = name;
        this.designation = designation;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEmail() {
        return email;
    }
}

