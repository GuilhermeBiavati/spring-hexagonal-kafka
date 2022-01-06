package com.example.demo.adapters.outbound.producers;

import com.example.demo.application.domain.Email;
import com.example.demo.application.ports.SendKafkaServicePort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.google.gson.Gson;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailProducer implements SendKafkaServicePort {

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private Gson gson;

    public void sendKafka(Email email) {
        kafkaTemplate.send(topicName, gson.toJson(email));
    }
}
