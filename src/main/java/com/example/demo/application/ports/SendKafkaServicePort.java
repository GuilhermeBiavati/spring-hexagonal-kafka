package com.example.demo.application.ports;

import com.example.demo.application.domain.Email;

public interface SendKafkaServicePort {
    void sendKafka(Email email);
}
