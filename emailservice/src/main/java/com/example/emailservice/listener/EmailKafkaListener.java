package com.example.emailservice.listener;

import com.example.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailKafkaListener {

    private final EmailService emailService;

    @Autowired
    public EmailKafkaListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "email-notifications", groupId = "email-consumer-group")
    public void listen(String message) {
        // Parse message for email details
        String[] parts = message.split(";");
        String to = parts[0];
        String subject = parts[1];
        String body = parts[2];

        // Send the email
        emailService.sendEmail(to, subject, body);
    }
}