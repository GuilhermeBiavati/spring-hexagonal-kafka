package com.example.demo.adapters.inbound.consumers;

import com.example.demo.adapters.dtos.EmailDto;
import com.example.demo.application.domain.Email;
import com.example.demo.application.ports.EmailServicePort;
import com.google.gson.Gson;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    EmailServicePort emailServicePort;

    public EmailConsumer(EmailServicePort emailService) {
        this.emailServicePort = emailService;
    }

    @Autowired
    private Gson gson;

    @Value("${topic.name.consumer}")
    private String topicName;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> payload) {

        System.out.println(payload.value());

        Email email = gson.fromJson(payload.value(), Email.class);

        this.emailServicePort.sendEmail(email);

        System.out.println("Email Status: " +
                email.getStatusEmail().toString());
    }

}
