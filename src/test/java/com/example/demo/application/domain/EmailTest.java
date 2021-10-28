package com.example.demo.application.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    public void createEmail() {
        Email email = new Email("Guilherme", "guilhermebiavati@gmail.com", "guilhermebiavati@gmail.com", "subject",
                "text");
        assertNotNull(email);
        assertTrue(email.isValidUUID(email.getEmailId().toString()));
        assertEquals(email.getOwnerRef(), "Guilherme");
        assertEquals(email.getEmailFrom(), "guilhermebiavati@gmail.com");
        assertEquals(email.getEmailTo(), "guilhermebiavati@gmail.com");
        assertEquals(email.getSubject(), "subject");
        assertEquals(email.getText(), "text");

        email = new Email(UUID.fromString("3a81f488-a2e3-42be-beef-28b25c137f00"), "Guilherme",
                "guilhermebiavati@gmail.com", "guilhermebiavati@gmail.com", "subject", "text");

        assertNotNull(email);
        assertTrue(email.isValidUUID(email.getEmailId().toString()));
        assertEquals(email.getEmailId().toString(), "3a81f488-a2e3-42be-beef-28b25c137f00");
        assertEquals(email.getOwnerRef(), "Guilherme");
        assertEquals(email.getEmailFrom(), "guilhermebiavati@gmail.com");
        assertEquals(email.getEmailTo(), "guilhermebiavati@gmail.com");
        assertEquals(email.getSubject(), "subject");
        assertEquals(email.getText(), "text");
    }

}
