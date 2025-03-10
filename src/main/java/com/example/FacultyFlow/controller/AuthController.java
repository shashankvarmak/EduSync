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
    private final FacultyRepository facultyRepo;

    public AuthController(UserRepo userRepo, FacultyRepository facultyRepo) {
        this.userRepo = userRepo;
        this.facultyRepo = facultyRepo;
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String role,
                               @RequestParam String email,
                               @RequestParam String password,
                               HttpSession session,
                               Model model) {
        System.out.println("🔍 Login attempt: Role = " + role + ", Email = " + email);
        if("admin".equalsIgnoreCase(role)){
            if (email.equalsIgnoreCase("shashankvarma@edu.com") && password.equals("1308")) {
                session.setAttribute("loggedInUserEmail", email);
                session.setAttribute("role", "ADMIN");
                return "redirect:/admin/dashboard"; // Redirect to admin dashboard
            }
        }
        if ("student".equalsIgnoreCase(role)) {
            // Check in users table
            User student = userRepo.findByEmail(email);
            if (student == null || !student.getPassword().equals(password)) {
                model.addAttribute("error", "Invalid student email or password!");
                return "login";
            }
            session.setAttribute("loggedInUserEmail", student.getEmail());
            session.setAttribute("role", "STUDENT");
            return "redirect:/student/dashboard";

        } else if ("faculty".equalsIgnoreCase(role)) {
            // Check in faculty table
            Faculty faculty = facultyRepo.findByEmail(email);
            if (faculty == null || !faculty.getPassword().equals(password)) {
                model.addAttribute("error", "Invalid faculty email or password!");
                return "login";
            }
            session.setAttribute("loggedInUserEmail", faculty.getEmail());
            session.setAttribute("role", "FACULTY");
            return "redirect:/faculty/dashboard";
        }

        model.addAttribute("error", "Invalid role selected!");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Clear session data
        return "redirect:/login";
    }
}