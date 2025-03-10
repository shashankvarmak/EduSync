package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.service.LeaveRequestService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/leave")
public class AdminLeaveController {

    private final LeaveRequestService leaveRequestService;

    public AdminLeaveController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    // Display all leave requests
    @GetMapping("/requests")
    public String viewLeaveRequests(HttpSession session, Model model) {
        // Optionally, check if the session role is ADMIN
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("ADMIN")) {
            return "redirect:/login";
        }

        model.addAttribute("leaveRequests", leaveRequestService.getAllLeaveRequests());
        return "admin/leave_requests"; // Create a Thymeleaf template at templates/admin/leave_requests.html
    }

    // Update the status of a leave request (e.g., approve or reject)
    @PostMapping("/update")
    public String updateLeaveRequestStatus(@RequestParam Long requestId,
                                           @RequestParam String status) {
        leaveRequestService.updateLeaveRequestStatus(requestId, status);
        return "redirect:/admin/leave/requests";
    }
}
