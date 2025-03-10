package com.example.FacultyFlow.service;

import com.example.FacultyFlow.model.LeaveRequest;
import com.example.FacultyFlow.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    // Save a new leave request
    public void submitLeaveRequest(LeaveRequest request) {
        leaveRequestRepository.save(request);
    }

    // Retrieve leave requests submitted by a specific faculty
    public List<LeaveRequest> getLeaveRequestsByFaculty(String facultyEmail) {
        return leaveRequestRepository.findByFacultyEmail(facultyEmail);
    }

    // Retrieve all leave requests (for admin)
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    // Update status of a leave request
    public void updateLeaveRequestStatus(Long id, String status) {
        LeaveRequest request = leaveRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("Leave request not found"));
        request.setStatus(status);
        leaveRequestRepository.save(request);
    }
}
