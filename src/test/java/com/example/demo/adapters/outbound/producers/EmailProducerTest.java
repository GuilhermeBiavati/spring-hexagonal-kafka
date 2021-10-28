package com.example.demo.adapters.outbound.producers;

import static org.mockito.Mockito.verify;

import com.example.demo.application.domain.Email;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmailProducerTest {

    private EmailProducer underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmailProducer();
    }

    @Test
    @Disabled
    void itShouldSendKafka() {

        // given
        Email email = new Email();

        // when

        underTest.sendKafka(email);
        // then

        // verify()

    }
}
