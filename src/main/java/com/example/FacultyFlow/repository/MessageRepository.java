package com.example.FacultyFlow.repository;

import com.example.FacultyFlow.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT DISTINCT m.senderEmail FROM Message m WHERE m.receiverEmail = :email " +
            "UNION " +
            "SELECT DISTINCT m.receiverEmail FROM Message m WHERE m.senderEmail = :email")
    List<String> findDistinctChatUsers(String email);


    @Query("SELECT m FROM Message m WHERE " +
            "(m.senderEmail = :senderEmail AND m.receiverEmail = :receiverEmail) " +
            "OR (m.senderEmail = :receiverEmail AND m.receiverEmail = :senderEmail) " +
            "ORDER BY m.timestamp ASC")
    List<Message> findBySenderAndReceiver(String senderEmail, String receiverEmail);
}