package com.example.FacultyFlow.service;

import com.example.FacultyFlow.model.Announcement;
import com.example.FacultyFlow.repository.AnnouncementRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnnouncementService {
    private final AnnouncementRepo announcementRepo;

    public AnnouncementService(AnnouncementRepo announcementRepo) {
        this.announcementRepo = announcementRepo;
    }

    // Save a new announcement
    public void saveAnnouncement(Announcement announcement) {
        announcementRepo.save(announcement);
    }

    // Get all announcements
    public List<Announcement> getAllAnnouncements() {
        return announcementRepo.findAll();
    }
}
