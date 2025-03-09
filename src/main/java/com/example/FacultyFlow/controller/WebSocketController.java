package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.model.Message;
import com.example.FacultyFlow.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class WebSocketController {

    private final MessageService messageService;

    public WebSocketController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/sendMessage")  // Maps messages sent from clients
    @SendTo("/topic/messages")  // Sends the message to subscribers
    public Message sendMessage(Message message) {
        message.setTimestamp(LocalDateTime.now());  // Set message timestamp
        messageService.saveMessage(message);  // Store message in the database
        return message;
    }
}
