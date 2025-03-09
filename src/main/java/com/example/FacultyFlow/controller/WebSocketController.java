package com.example.FacultyFlow.controller;

import com.example.FacultyFlow.model.Message;
import com.example.FacultyFlow.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessageService messageService;

    public WebSocketController(SimpMessagingTemplate messagingTemplate, MessageService messageService) {
        this.messagingTemplate = messagingTemplate;
        this.messageService = messageService;
    }

    @MessageMapping("/chat")
    public void handleMessage(@Payload Message message) {
        System.out.println("WebSocket received: " + message.getSenderEmail() + " -> " + message.getReceiverEmail());

        messageService.sendMessage(message.getSenderEmail(), message.getReceiverEmail(), message.getContent());

        messagingTemplate.convertAndSendToUser(message.getReceiverEmail(), "/queue/messages", message);
        messagingTemplate.convertAndSendToUser(message.getSenderEmail(), "/queue/messages", message);
    }
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) {
        message.setTimestamp(LocalDateTime.now());
        messageService.saveMessage(message);
        return message;
    }


}
