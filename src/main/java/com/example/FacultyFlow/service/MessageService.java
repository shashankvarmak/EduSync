package com.example.FacultyFlow.service;

import com.example.FacultyFlow.model.Message;
import com.example.FacultyFlow.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<String> getChatUsers(String email) {
        return messageRepository.findDistinctChatUsers(email);
    }

    public List<Message> getConversation(String sender, String receiver) {
        return messageRepository.findBySenderAndReceiver(sender, receiver);
    }

    public void sendMessage(String sender, String receiver, String content) {
        Message message = new Message(sender, receiver, content);
        messageRepository.save(message);
    }
}