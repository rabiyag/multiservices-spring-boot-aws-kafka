package com.example.emailservice.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSesConfig {

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(
                "your-access-key-id", 
                "your-secret-access-key"
        );
        return AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion("us-east-1") // Use your region
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}