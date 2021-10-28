package com.example.demo.application.ports;

import com.example.demo.application.domain.Email;

public interface SendEmailServicePort {
    void sendEmailSmtp(Email email);
}
