package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.model.User;
import com.example.FacultyFlow.model.Faculty;
import com.example.FacultyFlow.repository.UserRepo;
import com.example.FacultyFlow.repository.FacultyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    private final UserRepo userRepo;
    private final FacultyRepository facultyRepo; // Repository for faculty

    public AuthController(UserRepo userRepo, FacultyRepository facultyRepo) {
        this.userRepo = userRepo;
        this.facultyRepo = facultyRepo;
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email,
                               @RequestParam String password,
                               HttpSession session,
                               Model model) {
        // First, check if the user is a student
        User student = userRepo.findByEmail(email);
        if (student != null && student.getPassword().equals(password)) {
            session.setAttribute("loggedInUserEmail", student.getEmail());
            session.setAttribute("role", "STUDENT");
            return "redirect:/student/dashboard";
        }

        // If not a student, check if the user is a faculty member
        Faculty faculty = facultyRepo.findByEmail(email);
        if (faculty != null && faculty.getPassword().equals(password)) {
            session.setAttribute("loggedInUserEmail", faculty.getEmail());
            session.setAttribute("role", "FACULTY");
            return "redirect:/faculty/dashboard";
        }

        // If neither student nor faculty, return login error
        model.addAttribute("error", "Invalid email or password!");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Clear session data
        return "redirect:/login"; // Redirect to login page after logout
    }
}
