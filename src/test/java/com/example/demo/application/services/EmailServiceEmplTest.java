// package com.example.demo.application.services;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.doThrow;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.never;

// import java.time.LocalDateTime;
// import java.util.UUID;

// import com.example.demo.application.domain.Email;
// import com.example.demo.application.domain.PageInfo;
// import com.example.demo.application.domain.enums.StatusEmail;
// import com.example.demo.application.ports.EmailRepositoryPort;
// import com.example.demo.application.ports.SendEmailServicePort;
// import com.example.demo.application.ports.SendKafkaServicePort;

// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.ArgumentCaptor;
// import org.mockito.BDDMockito;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;

// @ExtendWith(MockitoExtension.class)
// public class EmailServiceEmplTest {

// @Mock
// private EmailRepositoryPort emailRepositoryPort;
// @Mock
// private SendEmailServicePort sendEmailServicePort;
// @Mock
// private SendKafkaServicePort sendKafkaServicePort;

// private EmailServiceImpl underTest;

// @BeforeEach
// void setUp() {
// underTest = new EmailServiceImpl(emailRepositoryPort, sendEmailServicePort,
// sendKafkaServicePort);
// }

// @Test
// // @Disabled
// void canSendEmail() {
// // given
// Email email = new Email("Guilherm", "guilhermebiavati@gmail.com",
// "guilhermebiavati@gmail.com", "sub", "text");
// // when
// underTest.sendEmail(email);
// // then
// verify(sendEmailServicePort).sendEmailSmtp(email);
// ArgumentCaptor<Email> emailArgumentCaptor =
// ArgumentCaptor.forClass(Email.class);
// verify(emailRepositoryPort).save(emailArgumentCaptor.capture());
// Email captEmail = emailArgumentCaptor.getValue();
// Assertions.assertThat(captEmail.getStatusEmail()).isEqualTo(StatusEmail.SENT);
// Assertions.assertThat(captEmail.getSendDateEmail()).isNotNull();
// }

// @Test
// void cantSendEmail() {
// // given
// Email email = new Email("Guilherm", "guilhermebiavati@gmail.com",
// "guilhermebiavati@gmail.com", "sub", "text");
// doThrow(new
// ArrayIndexOutOfBoundsException()).when(sendEmailServicePort).sendEmailSmtp(email);
// // when
// underTest.sendEmail(email);
// // then
// Assertions.assertThatThrownBy(() ->
// sendEmailServicePort.sendEmailSmtp(email)).isInstanceOf(Exception.class);
// ArgumentCaptor<Email> emailArgumentCaptor =
// ArgumentCaptor.forClass(Email.class);
// verify(emailRepositoryPort).save(emailArgumentCaptor.capture());
// Email captEmail = emailArgumentCaptor.getValue();
// Assertions.assertThat(captEmail.getStatusEmail()).isEqualTo(StatusEmail.ERROR);
// Assertions.assertThat(captEmail.getSendDateEmail()).isNotNull();

// }

// @Test
// void canSendKafka() {
// // given
// Email email = new Email("Guilherm", "guilhermebiavati@gmail.com",
// "guilhermebiavati@gmail.com", "sub", "text");
// // when
// underTest.sendKafka(email);
// // then
// verify(sendKafkaServicePort).sendKafka(email);
// }

// @Test
// @Disabled
// void willThrowWhenSendKafka() {

// // given
// Email email = new Email("Guilherm", "guilhermebiavati@gmail.com",
// "guilhermebiavati@gmail.com", "sub", "text");
// // when
// underTest.sendKafka(email);
// // then
// verify(sendKafkaServicePort).sendKafka(email);

// Assertions.assertThatThrownBy(() ->
// underTest.sendKafka(email)).isInstanceOf(Exception.class);

// // verify(sendKafkaServicePort, never()).deleteById(any());
// }

// @Test
// void findAll() {
// // given
// PageInfo pageInfo = new PageInfo();
// // when
// underTest.findAll(pageInfo);
// // then
// verify(emailRepositoryPort).findAll(pageInfo);
// }

// @Test
// void findById() {
// // given
// UUID id = UUID.randomUUID();
// // when
// underTest.findById(id);
// // then
// verify(emailRepositoryPort).findById(id);
// }

// @Test
// void canSave() {
// // given
// Email email = new Email("Guilherm", "guilhermebiavati@gmail.com",
// "guilhermebiavati@gmail.com", "sub", "text",
// LocalDateTime.now(), StatusEmail.SENT);
// // when
// underTest.save(email);

// // then
// ArgumentCaptor<Email> emailArgumentCaptor =
// ArgumentCaptor.forClass(Email.class);

// verify(emailRepositoryPort).save(emailArgumentCaptor.capture());

// Email captEmail = emailArgumentCaptor.getValue();

// Assertions.assertThat(captEmail).isEqualTo(email);
// }
// }
