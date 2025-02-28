package com.example.FacultyFlow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty_schedule")
public class FacultySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    private String day;
    private String period1;
    private String period2;
    private String period3;
    private String period4;
    private String period5;
    private String period6;
    private String period7;

    // Constructors
    public FacultySchedule() {}

    public FacultySchedule(Faculty faculty, String day, String period1, String period2, String period3, String period4, String period5, String period6, String period7) {
        this.faculty = faculty;
        this.day = day;
        this.period1 = period1;
        this.period2 = period2;
        this.period3 = period3;
        this.period4 = period4;
        this.period5 = period5;
        this.period6 = period6;
        this.period7 = period7;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Faculty getFaculty() { return faculty; }
    public void setFaculty(Faculty faculty) { this.faculty = faculty; }

    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }

    public String getPeriod1() { return period1; }
    public void setPeriod1(String period1) { this.period1 = period1; }

    public String getPeriod2() { return period2; }
    public void setPeriod2(String period2) { this.period2 = period2; }

    public String getPeriod3() { return period3; }
    public void setPeriod3(String period3) { this.period3 = period3; }

    public String getPeriod4() { return period4; }
    public void setPeriod4(String period4) { this.period4 = period4; }

    public String getPeriod5() { return period5; }
    public void setPeriod5(String period5) { this.period5 = period5; }

    public String getPeriod6() { return period6; }
    public void setPeriod6(String period6) { this.period6 = period6; }

    public String getPeriod7() { return period7; }
    public void setPeriod7(String period7) { this.period7 = period7; }
}
