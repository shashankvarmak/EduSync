package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.model.Message;
import com.example.FacultyFlow.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(MessageService messageService, SimpMessagingTemplate messagingTemplate) {
        this.messageService = messageService;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat.sendMessage") // Clients send messages here
    @SendToUser("/queue/messages") // Send messages to specific users
    public void sendMessage(Message message) {
        messageService.saveMessage(message);

        // Send message to the receiver's WebSocket queue
        messagingTemplate.convertAndSendToUser(
                message.getReceiverEmail(), "/queue/messages", message
        );
    }
}
