package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.model.Department;
import com.example.FacultyFlow.model.User;
import com.example.FacultyFlow.service.CourseDeptService;
import com.example.FacultyFlow.repository.UserRepo;
import com.example.FacultyFlow.service.DepartmentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {

    private final UserRepo userRepo;
    private final CourseDeptService courseDeptService;
    private final DepartmentService departmentService;

    public StudentController(UserRepo userRepo, CourseDeptService courseDeptService,DepartmentService departmentService) {
        this.userRepo = userRepo;
        this.courseDeptService = courseDeptService;
        this.departmentService = departmentService;
    }

    @GetMapping("/student/dashboard")
    public String studentDashboard(HttpSession session, Model model) {
        // Get logged-in student from session
        String email = (String) session.getAttribute("loggedInUserEmail");

        // Check if the email exists in session
        if (email == null) {
            return "redirect:/login"; // Redirect if no user is logged in
        }

        // Fetch student details from database
        User student = userRepo.findByEmail(email);
        if (student == null) {
            return "redirect:/login"; // Extra check to avoid errors
        }

        // Fetch courses for the student's department
        List<String> courses = courseDeptService.getCoursesByDepartment(student.getDepartment());

        // Fetch Announcements (Replace this with DB fetch later)
        List<String> announcements = List.of(
                "📢 Mid-Semester Exams start from March 10th!",
                "🚀 New AI/ML Course available for enrollment!",
                "📅 College Fest registrations open now!"
        );

        // Pass student details, courses, and announcements to Thymeleaf
        model.addAttribute("student", student);
        model.addAttribute("courses", courses);
        model.addAttribute("announcements", announcements);

        return "student/dashboard";
    }

    @GetMapping("/student/departments")
    public String showDepartments(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "student/departments";
    }
}
