package com.example.FacultyFlow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    @GetMapping("/")
    public String welcomes()
    {
        return "index";
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // This returns login.html
    }

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup"; // This returns signup.html
    }
}
