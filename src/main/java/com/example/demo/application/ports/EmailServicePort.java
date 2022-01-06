package com.example.demo.application.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.adapters.dtos.EmailDto;
import com.example.demo.application.domain.Email;
import com.example.demo.application.domain.PageInfo;

public interface EmailServicePort {

    Email sendEmail(Email email);

    void sendKafka(Email email);

    // List<Email> findAll(PageInfo pageInfo);
    Iterable<Email> findAll(PageInfo pageInfo);

    Optional<Email> findById(UUID emailId);

    Email save(Email email);
}
