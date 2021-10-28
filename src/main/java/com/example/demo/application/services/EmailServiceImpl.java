package com.example.demo.application.services;

import com.example.demo.application.domain.Email;
import com.example.demo.application.domain.PageInfo;
import com.example.demo.application.domain.enums.StatusEmail;
import com.example.demo.application.ports.EmailRepositoryPort;
import com.example.demo.application.ports.EmailServicePort;
import com.example.demo.application.ports.SendEmailServicePort;
import com.example.demo.application.ports.SendKafkaServicePort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EmailServiceImpl implements EmailServicePort {

    private final EmailRepositoryPort emailRepositoryPort;
    private final SendEmailServicePort sendEmailServicePort;
    private final SendKafkaServicePort sendKafkaServicePort;

    public EmailServiceImpl(final EmailRepositoryPort emailRepositoryPort,
            final SendEmailServicePort sendEmailServicePort, SendKafkaServicePort sendKafkaServicePort) {
        this.emailRepositoryPort = emailRepositoryPort;
        this.sendEmailServicePort = sendEmailServicePort;
        this.sendKafkaServicePort = sendKafkaServicePort;
    }

    @Override
    public Email sendEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());
        try {
            sendEmailServicePort.sendEmailSmtp(email);
            email.setStatusEmail(StatusEmail.SENT);
        } catch (Exception e) {
            email.setStatusEmail(StatusEmail.ERROR);
        }

        return save(email);
    }

    @Override
    public void sendKafka(Email email) {

        try {
            sendKafkaServicePort.sendKafka(email);
        } catch (Exception e) {

        }

    }

    @Override
    public List<Email> findAll(PageInfo pageInfo) {
        // inserir manipulação de dados/regras
        return emailRepositoryPort.findAll(pageInfo);
    }

    @Override
    public Optional<Email> findById(UUID emailId) {
        // inserir manipulação de dados/regras
        return emailRepositoryPort.findById(emailId);
    }

    @Override
    public Email save(Email email) {
        return emailRepositoryPort.save(email);
    }
}