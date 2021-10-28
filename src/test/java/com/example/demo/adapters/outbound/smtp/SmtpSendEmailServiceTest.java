package com.example.demo.adapters.outbound.smtp;

import static org.mockito.Mockito.verify;

import com.example.demo.application.domain.Email;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class SmtpSendEmailServiceTest {

    private SmtpSendEmailService underTest;

    @BeforeEach
    void setUp() {
        underTest = new SmtpSendEmailService();
    }

    @Test
    @Disabled
    void itShouldSendEmailSmtp() {
        // given
        Email email = new Email("Guilehrme", "guilhermebiavati@gmail.com", "guilhermebiavati@gmail.com", "sub", "text");
        // when
        underTest.sendEmailSmtp(email);
        // then

    }
}
