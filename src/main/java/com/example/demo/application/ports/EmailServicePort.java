package com.example.demo.application.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.application.domain.Email;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface EmailServicePort {

    Email sendEmail(Email email);

    void sendKafka(Email email);

    Page<Email> findAll(Pageable pageable);
    // Iterable<Email> findAll(Pageable pageable);

    Optional<Email> findById(UUID emailId);

    Email save(Email email);
}
