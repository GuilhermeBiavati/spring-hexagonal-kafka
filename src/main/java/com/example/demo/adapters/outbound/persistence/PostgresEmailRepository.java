package com.example.demo.adapters.outbound.persistence;

// import com.example.demo.adapters.outbound.persistence.entities.EmailEntity;
import com.example.demo.application.domain.Email;
import com.example.demo.application.domain.PageInfo;
import com.example.demo.application.ports.EmailRepositoryPort;
// import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public Iterable<Email> findAll() {
        // Pageable pageable = PageRequest.of(pageInfo.getPageNumber(),
        // pageInfo.getPageSize());
        // return emailRepository.findAll(pageable).stream().map(entity ->
        // modelMapper.map(entity, Email.class))
        // .collect(Collectors.toList());

        return this.emailRepository.findAll();
    }

    @Override
    public Optional<Email> findById(UUID emailId) {
        return this.emailRepository.findById(emailId);
    }
}