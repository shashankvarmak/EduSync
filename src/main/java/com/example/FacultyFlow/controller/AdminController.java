package com.example.FacultyFlow.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public String showAdminDashboard(HttpSession session, Model model) {
        // Check if the logged-in user is an admin
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("ADMIN")) {
            return "redirect:/login"; // Redirect non-admin users to the login page
        }

        // Optionally add admin details to the model if needed
        model.addAttribute("adminEmail", "shashankvarma@edu.com");
        model.addAttribute("adminRole", "ADMIN");
        model.addAttribute("profession", "Head of All Departments");

        return "admin/dashboard"; // This should match the Thymeleaf template at templates/admin/dashboard.html
    }
}
