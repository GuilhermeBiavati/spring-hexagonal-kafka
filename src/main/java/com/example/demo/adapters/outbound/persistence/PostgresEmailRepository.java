package com.example.demo.adapters.outbound.persistence;

import com.example.demo.application.domain.Email;
import com.example.demo.application.domain.PageInfo;
import com.example.demo.application.ports.EmailRepositoryPort;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

@Repository
public class PostgresEmailRepository implements EmailRepositoryPort {

    private SpringDataPostgresEmailRepository emailRepository;

    public PostgresEmailRepository(SpringDataPostgresEmailRepository springDataPostgresEmailRepository) {
        this.emailRepository = springDataPostgresEmailRepository;
    }

    @Override
    public Email save(Email email) {
        return emailRepository.save(email);
    }

    @Override
    public Page<Email> findAll(Pageable pageable) {
        return this.emailRepository.findAll(pageable);
    }

    @Override
    public Optional<Email> findById(UUID emailId) {
        return this.emailRepository.findById(emailId);
    }

    // @Override
    // public Iterable<Email> findAll(
    // org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable
    // pageable) {
    // // TODO Auto-generated method stub
    // return null;
    // }
}