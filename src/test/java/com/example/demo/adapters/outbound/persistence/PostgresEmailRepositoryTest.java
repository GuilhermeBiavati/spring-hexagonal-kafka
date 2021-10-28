package com.example.demo.adapters.outbound.persistence;

import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

import com.example.demo.adapters.outbound.persistence.entities.EmailEntity;
import com.example.demo.application.domain.Email;
import com.example.demo.application.domain.PageInfo;
import com.example.demo.application.domain.enums.StatusEmail;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class PostgresEmailRepositoryTest {

    @Mock
    private SpringDataPostgresEmailRepository emailRepository;
    private PostgresEmailRepository underTest;

    @Autowired
    ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        underTest = new PostgresEmailRepository(emailRepository);
    }

    @Test
    @Disabled
    void itShouldCheckIfSave() {
        // given
        Email email = new Email("Guilherm", "guilhermebiavati@gmail.com", "guilhermebiavati@gmail.com", "sub", "text",
                LocalDateTime.now(), StatusEmail.SENT);

        // when
        underTest.save(email);

        // then
        ArgumentCaptor<EmailEntity> emailArgumentCaptor = ArgumentCaptor.forClass(EmailEntity.class);

        verify(emailRepository).save(emailArgumentCaptor.capture());

        EmailEntity captEmail = emailArgumentCaptor.getValue();

        Assertions.assertThat(modelMapper.map(captEmail, Email.class)).isEqualTo(email);
    }

    @Test

    @Disabled
    void canFindAll() {
        // given
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNumber(1);
        pageInfo.setPageSize(15);
        // when
        underTest.findAll(pageInfo);
        // then

        verify(emailRepository).findAll();
    }

    @Test
    @Disabled
    void itShouldCheckfindById() {

        // underTest.findById();
        // verify(emailRepository).findById(id)
    }
}
