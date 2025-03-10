package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.model.Faculty;
import com.example.FacultyFlow.repository.FacultyRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/faculty")
public class AdminFacultyController {

    private final FacultyRepository facultyRepository;

    public AdminFacultyController(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    // List all faculty members
    @GetMapping("/list")
    public String listFaculties(HttpSession session, Model model) {
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("ADMIN")) {
            return "redirect:/login";
        }
        model.addAttribute("faculties", facultyRepository.findAll());
        return "admin/faculty_list";  // Thymeleaf template: templates/admin/faculty_list.html
    }

    // Show the form to add a new faculty member
    @GetMapping("/add")
    public String showAddFacultyForm(HttpSession session, Model model) {
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("ADMIN")) {
            return "redirect:/login";
        }
        model.addAttribute("faculty", new Faculty());
        return "admin/add_faculty";  // Thymeleaf template: templates/admin/add_faculty.html
    }

    // Process the form to add a new faculty member
    @PostMapping("/add")
    public String addFaculty(@ModelAttribute Faculty faculty, HttpSession session) {
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("ADMIN")) {
            return "redirect:/login";
        }
        facultyRepository.save(faculty);
        return "redirect:/admin/faculty/list";
    }

    // Delete a faculty member by ID
    @PostMapping("/delete/{id}")
    public String deleteFaculty(@PathVariable Long id, HttpSession session) {
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("ADMIN")) {
            return "redirect:/login";
        }
        facultyRepository.deleteById(id);
        return "redirect:/admin/faculty/list";
    }
}
