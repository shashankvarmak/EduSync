package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.model.Faculty;
import com.example.FacultyFlow.model.FacultySchedule;
import com.example.FacultyFlow.repository.FacultyRepository;
import com.example.FacultyFlow.service.FacultyScheduleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FacultyController {

    private final FacultyRepository facultyRepo;
    private final FacultyScheduleService facultyScheduleService;

    public FacultyController(FacultyRepository facultyRepo ,FacultyScheduleService facultyScheduleService) {
        this.facultyRepo = facultyRepo;
        this.facultyScheduleService=facultyScheduleService;
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

        // Fetch faculty schedule from the database
        List<FacultySchedule> schedule = facultyScheduleService.getScheduleByFaculty(faculty.getId());

        // Pass faculty and schedule details to Thymeleaf
        model.addAttribute("faculty", faculty);
        model.addAttribute("schedule", schedule);

        return "faculty/dashboard";
    }
    @GetMapping("/faculty/list")
    public List<Faculty> getAllFaculty() {
        return facultyRepo.findAll();
    }


}
