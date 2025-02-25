package com.example.FacultyFlow.controller;


import com.example.FacultyFlow.model.Department;
import com.example.FacultyFlow.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public String getDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "departments";  // This maps to departments.html
    }

    @GetMapping("/departments/{code}")
    public String getDepartmentDetails(@PathVariable String code, Model model) {
        Department department = departmentService.getDepartmentByCode(code);

        if (department == null) {
            return "redirect:/student/departments"; // Redirect if department is not found
        }

        model.addAttribute("department", department);
        return "student/department-details";
    }



}
