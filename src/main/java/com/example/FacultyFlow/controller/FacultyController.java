package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.model.Faculty;
import com.example.FacultyFlow.repository.FacultyRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacultyController {

    private final FacultyRepository facultyRepo;

    public FacultyController(FacultyRepository facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    @GetMapping("/faculty/dashboard")
    public String facultyDashboard(HttpSession session, Model model) {
        // Get logged-in faculty email from session
        String email = (String) session.getAttribute("loggedInUserEmail");

        if (email == null) {
            return "redirect:/login"; // Redirect if no user is logged in
        }

        // Fetch faculty details from database
        Faculty faculty = facultyRepo.findByEmail(email);

        if (faculty == null) {
            return "redirect:/login"; // Extra check to avoid errors
        }

        // Pass faculty details to Thymeleaf
        model.addAttribute("faculty", faculty);

        return "faculty/dashboard";
    }
}
