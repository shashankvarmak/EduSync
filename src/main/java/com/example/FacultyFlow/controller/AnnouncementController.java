package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.model.Announcement;
import com.example.FacultyFlow.service.AnnouncementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/announcements")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    // Show all announcements
    @GetMapping
    public String showAnnouncements(Model model) {
        List<Announcement> announcements = announcementService.getAllAnnouncements();
        model.addAttribute("announcements", announcements);
        return "announcements"; // Make sure you have announcements.html
    }

    // Show form to create an announcement
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("announcement", new Announcement());
        return "create-announcement"; // Create this HTML file
    }

    // Handle form submission to create an announcement
    @PostMapping("/save")
    public String saveAnnouncement(@ModelAttribute Announcement announcement) {
        announcementService.saveAnnouncement(announcement);
        return "redirect:/announcements";
    }
}
