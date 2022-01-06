package com.example.demo.adapters.outbound.persistence;

import com.example.demo.application.domain.Email;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.UUID;

public interface SpringDataPostgresEmailRepository extends PagingAndSortingRepository<Email, UUID> {
}