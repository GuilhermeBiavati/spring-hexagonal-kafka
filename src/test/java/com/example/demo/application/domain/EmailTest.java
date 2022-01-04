package com.example.demo.application.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.util.UUID;

import com.example.demo.application.domain.enums.StatusEmail;

import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    public void throwIllegalArgumentExceptionWhenOwnerRefIsNull() {
        var e = assertThrows(IllegalArgumentException.class,
                () -> new Email(null, "guilhermebiavati@gmail.com", "guilhermebiavati@gmail.com", "Subject", "Text"));
        assertEquals("ownerRef is marked non-null, but is null", e.getMessage());
    }

    @Test
    public void throwIllegalArgumentExceptionWhenOwnerRefIsBlank() {
        var e = assertThrows(IllegalArgumentException.class,
                () -> new Email(null, "guilhermebiavati@gmail.com",
                        "guilhermebiavati@gmail.com", "Subject", "Text"));
        assertEquals("ownerRef is marked non-null, but is null", e.getMessage());
    }

    @Test
    public void throwIllegalArgumentExceptionWhenEmailFromIsNull() {
        var e = assertThrows(IllegalArgumentException.class,
                () -> new Email("guilherme", null, "guilhermebiavati@gmail.com", "Subject",
                        "Text"));
        assertEquals("emailFrom is marked non-null, but is null", e.getMessage());
    }

    @Test
    public void throwIllegalArgumentExceptionWhenEmailFromIsBlank() {
        var e = assertThrows(IllegalArgumentException.class,
                () -> new Email("guilherme", "",
                        "guilhermebiavati@gmail.com", "Subject", "Text"));
        assertEquals("emailFrom is marked not-blank but is blank", e.getMessage());
    }

    @Test
    public void throwIllegalArgumentExceptionWhenEmailToIsNull() {
        var e = assertThrows(IllegalArgumentException.class,
                () -> new Email("guilherme", "guilhermebiavati@gmail.com", null, "Subject",
                        "Text"));
        assertEquals("emailTo is marked non-null, but is null", e.getMessage());
    }

    @Test
    public void throwIllegalArgumentExceptionWhenEmailToIsBlank() {
        var e = assertThrows(IllegalArgumentException.class,
                () -> new Email("guilherme", "guilhermebiavati@gmail.com",
                        "", "Subject", "Text"));
        assertEquals("emailTo is marked not-blank but is blank", e.getMessage());
    }

    @Test
    public void throwIllegalArgumentExceptionWhenSubjectIsNull() {
        var e = assertThrows(IllegalArgumentException.class,
                () -> new Email("guilherme", "guilhermebiavati@gmail.com", "guilhermebiavati@gmail.com", null,
                        "Text"));
        assertEquals("subject is marked non-null, but is null", e.getMessage());
    }

    @Test
    public void throwIllegalArgumentExceptionWhenSubjectIsBlank() {
        var e = assertThrows(IllegalArgumentException.class,
                () -> new Email("guilherme", "guilhermebiavati@gmail.com",
                        "guilhermebiavati@gmail.com", "", "Text"));
        assertEquals("subject is marked not-blank but is blank", e.getMessage());
    }

    @Test
    public void throwIllegalArgumentExceptionWhenTextIsNull() {
        var e = assertThrows(IllegalArgumentException.class,
                () -> new Email("guilherme", "guilhermebiavati@gmail.com", "guilhermebiavati@gmail.com", "Subject",
                        null));
        assertEquals("text is marked non-null, but is null", e.getMessage());
    }

    @Test
    public void throwIllegalArgumentExceptionWhenTextIsBlank() {
        var e = assertThrows(IllegalArgumentException.class,
                () -> new Email("guilherme", "guilhermebiavati@gmail.com",
                        "guilhermebiavati@gmail.com", "Subject", ""));
        assertEquals("text is marked not-blank but is blank", e.getMessage());
    }

    @Test
    public void throwIllegalArgumentExceptionWhenStatusEmailIsNull() {
        var e = assertThrows(IllegalArgumentException.class,
                () -> {
                    Email email = new Email("guilherme", "guilhermebiavati@gmail.com", "guilhermebiavati@gmail.com",
                            "Subject",
                            "Text");

                    email.setStatusEmail(null);
                });

        assertEquals("type is marked non-null but is null", e.getMessage());
    }

    // @Test
    // public void throwIllegalArgumentExceptionWhenStatusEmailIsInvalid() {
    // var e = assertThrows(IllegalArgumentException.class,
    // () -> {
    // Email entity = mock(Email.class);
    // doThrow(IllegalArgumentException.class).when(entity).setStatusEmail(StatusEmail.ERROR);
    // entity.setStatusEmail(StatusEmail.ERROR);
    // });

    // // assertEquals("type is marked non-null but is null", e.getMessage());
    // }

    @Test
    public void throwIllegalArgumentExceptionWhenIdIsNull() {

        var e = assertThrows(IllegalArgumentException.class,
                () -> new Email((UUID) null, "Guilherme", "guilhermebiavati@gmail.com",
                        "guilhermebiavati@gmail.com",
                        "Subject", "Text"));

        assertEquals("emailId is marked non-null, but is null", e.getMessage());
    }

    // @Test
    // public void throwIllegalArgumentExceptionWhenIdIsInvalid() {
    // var e = assertThrows(IllegalArgumentException.class,
    // () -> new Email(UUID.fromString("2312132"), "Guilherme",
    // "guilhermebiavati@gmail.com",
    // "guilhermebiavati@gmail.com",
    // "Subject", "Text"));

    // assertEquals("emailId is marked as valid uuid, but is not valid",
    // e.getMessage());

    // }

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
