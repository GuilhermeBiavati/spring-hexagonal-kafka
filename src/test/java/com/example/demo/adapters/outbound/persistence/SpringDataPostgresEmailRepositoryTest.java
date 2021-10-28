// package com.example.demo.adapters.outbound.persistence;

// import java.util.List;

// import com.example.demo.adapters.outbound.persistence.entities.EmailEntity;

// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// @DataJpaTest
// public class SpringDataPostgresEmailRepositoryTest {

// @Autowired
// private SpringDataPostgresEmailRepository emailRepository;

// @Test
// void itShouldCheckIfSave() {

// // given
// EmailEntity email = new EmailEntity("Guilherme", "Guilherme", "guilherme",
// "guilherme");

// // when
// EmailEntity savedEmail = emailRepository.save(email);
// // then

// Assertions.assertThat(savedEmail).isEqualTo(email);

// }

// @Test
// void itShouldCheckfindAll() {
// // given
// EmailEntity email = new EmailEntity("Guilherme", "Guilherme", "guilherme",
// "guilherme");
// emailRepository.save(email);

// // when
// List<EmailEntity> emails = emailRepository.findAll();

// // then
// Assertions.assertThat(emails.size()).isEqualTo(1);

// email = new EmailEntity("Guilherme", "Guilherme", "guilherme", "guilherme");

// emailRepository.save(email);

// emails = emailRepository.findAll();

// Assertions.assertThat(emails.size()).isEqualTo(2);
// }

// // @Test
// // void findById() {

// // EmailEntity emailEntity = new EmailEntity("Guilherme", "Guilherme",
// // "guilherme", "guilherme");
// // EmailEntity savedEmailEntity = emailRepository.save(emailEntity);

// // Optional<EmailEntity> emailEntity =
// // emailRepository.findById(savedEmailEntity);

// // }

// }
