package com.example.demo.application.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.application.domain.Email;
import com.example.demo.application.domain.PageInfo;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

public interface EmailRepositoryPort {
    Email save(Email email);

    // List<Email> findAll(PageInfo pageInfo);
    Page<Email> findAll(Pageable pageable);

    Optional<Email> findById(UUID emailId);
}
