package com.example.demo.application.services;

import com.example.demo.adapters.dtos.EmailDto;
import com.example.demo.application.domain.Email;
import com.example.demo.application.domain.PageInfo;
import com.example.demo.application.domain.enums.StatusEmail;
import com.example.demo.application.ports.EmailRepositoryPort;
import com.example.demo.application.ports.EmailServicePort;
import com.example.demo.application.ports.SendEmailServicePort;
import com.example.demo.application.ports.SendKafkaServicePort;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmailServiceImpl implements EmailServicePort {

    private EmailRepositoryPort emailRepositoryPort;
    private SendEmailServicePort sendEmailServicePort;
    private SendKafkaServicePort sendKafkaServicePort;

    public EmailServiceImpl(EmailRepositoryPort emailRepositoryPort,
            SendEmailServicePort sendEmailServicePort, SendKafkaServicePort sendKafkaService) {
        this.emailRepositoryPort = emailRepositoryPort;
        this.sendEmailServicePort = sendEmailServicePort;
        this.sendKafkaServicePort = sendKafkaService;
    }

    @Override
    public Email sendEmail(Email email) {

        // Email email = emailDto.toEntity();

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
    public Page<Email> findAll(Pageable pageable) {
        // inserir manipulação de dados/regras
        return this.emailRepositoryPort.findAll(pageable);
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