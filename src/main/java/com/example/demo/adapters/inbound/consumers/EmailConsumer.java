package com.example.demo.adapters.inbound.consumers;

import com.example.demo.adapters.dtos.EmailDto;
import com.example.demo.application.domain.Email;
import com.example.demo.application.ports.EmailServicePort;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.google.gson.Gson;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailConsumer {

    @Autowired
    EmailServicePort emailServicePort;

    @Autowired
    private Gson gson;

    @Value("${topic.name.consumer}")
    private String topicName;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        EmailDto emailDto = gson.fromJson(message, EmailDto.class);
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        emailServicePort.sendEmail(email);
        System.out.println("Email Status: " + email.getStatusEmail().toString());
    }

}
