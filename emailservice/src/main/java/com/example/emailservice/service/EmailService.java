package com.example.emailservice.service;


import com.amazonaws.services.ses.AmazonSimpleEmailService;
import com.amazonaws.services.ses.model.SendEmailRequest;
import com.amazonaws.services.ses.model.SendEmailResult;
import com.amazonaws.services.ses.model.Message;
import com.amazonaws.services.ses.model.Content;
import com.amazonaws.services.ses.model.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final AmazonSimpleEmailService sesClient;

    @Autowired
    public EmailService(AmazonSimpleEmailService sesClient) {
        this.sesClient = sesClient;
    }

    public void sendEmail(String to, String subject, String body) {
        try {
            SendEmailRequest request = new SendEmailRequest()
                    .withDestination(new Destination().withToAddresses(to))
                    .withMessage(new Message()
                            .withBody(new com.amazonaws.services.ses.model.Body()
                                    .withText(new Content().withData(body)))
                            .withSubject(new Content().withData(subject)))
                    .withSource("your-verified-email@example.com"); // Must be verified in SES

            SendEmailResult result = sesClient.sendEmail(request);
            System.out.println("Email sent: " + result.getMessageId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}