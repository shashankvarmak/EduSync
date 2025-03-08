package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.model.Faculty;
import com.example.FacultyFlow.model.Message;
import com.example.FacultyFlow.service.FacultyService;
import com.example.FacultyFlow.service.MessageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;
    private final FacultyService facultyService; // Service to fetch faculty

    public MessageController(MessageService messageService, FacultyService facultyService) {
        this.messageService = messageService;
        this.facultyService = facultyService;
    }

    @GetMapping
    public String showInbox(HttpSession session, Model model) {
        String loggedInEmail = (String) session.getAttribute("loggedInUserEmail");
        String role = (String) session.getAttribute("role"); // Get role

        if (loggedInEmail == null) {
            return "redirect:/login"; // Redirect if not logged in
        }

        if ("STUDENT".equals(role)) {
            // If student, show all faculty
            List<Faculty> facultyList = facultyService.getAllFaculty();
            model.addAttribute("facultyList", facultyList);
        } else {
            // If faculty, show past conversations
            List<String> chatUsers = messageService.getChatUsers(loggedInEmail);
            model.addAttribute("chatUsers", chatUsers);
        }

        model.addAttribute("role", role); // Pass role to Thymeleaf
        return "messages/inbox";
    }

    @GetMapping("/chat/{email}")
    public String showConversation(@PathVariable String email, HttpSession session, Model model) {
        String loggedInEmail = (String) session.getAttribute("loggedInUserEmail");

        if (loggedInEmail == null) {
            return "redirect:/login";
        }

        List<Message> conversation = messageService.getConversation(loggedInEmail, email);
        model.addAttribute("conversation", conversation);
        model.addAttribute("receiverEmail", email);
        return "messages/chat";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String receiverEmail,
                              @RequestParam String content,
                              HttpSession session) {
        String senderEmail = (String) session.getAttribute("loggedInUserEmail");

        if (senderEmail == null) {
            return "redirect:/login";
        }

        messageService.sendMessage(senderEmail, receiverEmail, content);
        return "redirect:/messages/chat/" + receiverEmail;
    }
}