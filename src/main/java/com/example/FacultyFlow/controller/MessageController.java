package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.model.Faculty;
import com.example.FacultyFlow.model.Message;
import com.example.FacultyFlow.service.FacultyService;
import com.example.FacultyFlow.service.MessageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        if (loggedInEmail == null) {
            return "redirect:/login";
        }

        // Existing chat users (from previous conversations)
        List<String> chatUsers = messageService.getChatUsers(loggedInEmail);
        model.addAttribute("chatUsers", chatUsers);

        // Fetch all faculty members (so the student can start a new conversation)
        List<Faculty> facultyList = facultyService.getAllFaculty();
        model.addAttribute("facultyList", facultyList);

        return "messages/inbox";
    }

    @GetMapping("/chat/{email}")
    @ResponseBody
    public List<Message> getConversation(@PathVariable String email, HttpSession session) {
        String loggedInEmail = (String) session.getAttribute("loggedInUserEmail");

        if (loggedInEmail == null) {
            return new ArrayList<>(); // Return empty if not logged in
        }

        return messageService.getConversation(loggedInEmail, email);
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
