package com.example.FacultyFlow.model;


import java.util.List;

public class Department{
    private String name;
    private String code;
    private List<Faculty> facultyList;

    public Department(String name, String code, List<Faculty> facultyList) {
        this.name = name;
        this.code = code;
        this.facultyList = facultyList;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public List<Faculty> getFacultyList() { return facultyList; }
    public void setFacultyList(List<Faculty> facultyList) { this.facultyList = facultyList; }
}
