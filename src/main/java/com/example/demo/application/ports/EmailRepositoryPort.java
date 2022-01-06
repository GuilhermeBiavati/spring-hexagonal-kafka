package com.example.demo.application.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.application.domain.Email;
import com.example.demo.application.domain.PageInfo;

public interface EmailRepositoryPort {
    Email save(Email email);

    // List<Email> findAll(PageInfo pageInfo);
    Iterable<Email> findAll();

    Optional<Email> findById(UUID emailId);
}
