package com.example.FacultyFlow.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leave_requests")
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Faculty who is requesting leave
    private String facultyEmail;

    private LocalDate startDate;
    private LocalDate endDate;

    // Reason for leave (optional)
    @Column(columnDefinition = "TEXT")
    private String reason;

    // Request status: PENDING, APPROVED, REJECTED
    private String status = "PENDING";

    // Default constructor
    public LeaveRequest() {}

    // Constructor with parameters
    public LeaveRequest(String facultyEmail, LocalDate startDate, LocalDate endDate, String reason) {
        this.facultyEmail = facultyEmail;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status = "PENDING";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFacultyEmail() { return facultyEmail; }
    public void setFacultyEmail(String facultyEmail) { this.facultyEmail = facultyEmail; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
