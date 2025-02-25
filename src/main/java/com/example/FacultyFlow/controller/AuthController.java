package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.model.User;
import com.example.FacultyFlow.repository.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;


@Controller
public class AuthController {

    private final UserRepo userRepo;

    public AuthController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/signup")
    public String processSignup(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String rollNo,
                                @RequestParam String department,
                                @RequestParam String password,
                                Model model) {
        System.out.println("✅ Signup request received!"); // Debug log

        // Check if email already exists
        if (userRepo.findByEmail(email) != null) {
            System.out.println("❌ Email already exists!");
            model.addAttribute("error", "Email already exists!");
            return "signup";
        }

        // Create and save user
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setRollNo(rollNo);
        user.setDepartment(department);
        user.setPassword(password); // Hash this later
        user.setRole("STUDENT");

        userRepo.save(user);

        System.out.println("✅ User saved successfully!");

        return "redirect:/login";
    }




    // Inside your login controller method
    @PostMapping("/login")
    public String processLogin(@RequestParam String email,
                               @RequestParam String password,
                               HttpSession session,
                               Model model) {
        // Check if the user exists
        User user = userRepo.findByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
            model.addAttribute("error", "Invalid email or password!");
            return "login";
        }

        // ✅ Store user email in session after successful login
        session.setAttribute("loggedInUserEmail", user.getEmail());

        // Redirect to the student dashboard after successful login
        return "redirect:/student/dashboard";
    }



}
