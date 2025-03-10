package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.model.LeaveRequest;
import com.example.FacultyFlow.service.LeaveRequestService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/faculty/leave")
public class FacultyLeaveController {

    private final LeaveRequestService leaveRequestService;

    public FacultyLeaveController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    // Show leave request form
    @GetMapping("/request")
    public String showLeaveRequestForm(HttpSession session, Model model) {
        String facultyEmail = (String) session.getAttribute("loggedInUserEmail");
        if (facultyEmail == null) {
            return "redirect:/login";
        }
        model.addAttribute("facultyEmail", facultyEmail);
        return "faculty/leave_request"; // Create a Thymeleaf template at templates/faculty/leave_request.html
    }

    // Process leave request submission
    @PostMapping("/submit")
    public String submitLeaveRequest(@RequestParam String startDate,
                                     @RequestParam String endDate,
                                     @RequestParam String reason,
                                     HttpSession session) {
        String facultyEmail = (String) session.getAttribute("loggedInUserEmail");
        if (facultyEmail == null) {
            return "redirect:/login";
        }

        // Parse dates (ensure you use proper date parsing or binding)
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        LeaveRequest request = new LeaveRequest(facultyEmail, start, end, reason);
        leaveRequestService.submitLeaveRequest(request);
        return "redirect:/faculty/dashboard"; // or a confirmation page
    }
    @GetMapping("/status")
    public String viewLeaveStatus(HttpSession session, Model model) {
        String facultyEmail = (String) session.getAttribute("loggedInUserEmail");
        if (facultyEmail == null) {
            return "redirect:/login";
        }
        // Fetch leave requests for the logged-in faculty
        List<LeaveRequest> leaveRequests = leaveRequestService.getLeaveRequestsByFaculty(facultyEmail);
        model.addAttribute("leaveRequests", leaveRequests);
        return "faculty/leave_status"; // Ensure this template exists in templates/faculty/leave_status.html
    }
}
