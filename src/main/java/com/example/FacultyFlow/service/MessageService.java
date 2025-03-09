package com.example.FacultyFlow.service;

import com.example.FacultyFlow.model.Message;
import com.example.FacultyFlow.repository.MessageRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate messagingTemplate; // WebSocket messaging

    public MessageService(MessageRepository messageRepository, SimpMessagingTemplate messagingTemplate) {
        this.messageRepository = messageRepository;
        this.messagingTemplate = messagingTemplate;
    }

    public List<String> getChatUsers(String email) {
        System.out.println("Fetching chat users for: " + email); // Debugging Step 1
        List<String> users = messageRepository.findDistinctChatUsers(email);
        System.out.println("Chat Users Found: " + users); // Debugging Step 2
        return users;
    }



    public List<Message> getConversation(String sender, String receiver) {
        return messageRepository.findBySenderAndReceiver(sender, receiver);
    }

    public void sendMessage(String sender, String receiver, String content) {
        Message message = new Message(sender, receiver, content);
        messageRepository.save(message);

        // Notify the receiver in real-time using WebSocket
        messagingTemplate.convertAndSendToUser(receiver, "/queue/messages", message);
    }

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}
