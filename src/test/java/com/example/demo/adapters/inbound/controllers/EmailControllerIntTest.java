// package com.example.demo.adapters.inbound.controllers;

// import com.example.demo.application.domain.Email;
// import com.example.demo.application.domain.PageInfo;
// import com.example.demo.application.ports.EmailServicePort;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import
// org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.ResultActions;
// import com.github.javafaker.Faker;
// import org.springframework.util.StringUtils;

// import static
// org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import java.util.List;

// @SpringBootTest
// @TestPropertySource(locations = "classpath:application-it.properties")
// @AutoConfigureMockMvc
// @Disabled
// class EmailControllerIntTest {

// @Autowired
// private MockMvc mockMvc;

// @Autowired
// private ObjectMapper objectMapper;

// @Autowired
// EmailServicePort emailServicePort;

// private final Faker faker = new Faker();

// @Test
// @Disabled
// void canSave() throws Exception {

// // given
// String ownerRef = String.format("%s %s", faker.name().firstName(),
// faker.name().lastName());
// String emailTo = String.format("%s@gmail.com",
// StringUtils.trimAllWhitespace(faker.name().firstName()));
// String emailFrom = String.format("%s@gmail.com",
// StringUtils.trimAllWhitespace(faker.name().firstName()));
// String subject = String.format("%s %s", faker.name().firstName());
// String text = String.format("%s %s", faker.name().firstName(),
// faker.name().lastName());

// Email email = new Email(ownerRef, emailTo, emailFrom, subject, text);

// // when
// ResultActions resultActions =
// mockMvc.perform(post("/sending-email").contentType(MediaType.APPLICATION_JSON)
// .content(objectMapper.writeValueAsString(email)));
// // then
// resultActions.andExpect(status().isOk());

// List<Email> emails = emailServicePort.findAll(new PageInfo(1, 15));

// Assertions.assertThat(emails).usingElementComparatorIgnoringFields("id").contains(email);

// }

// // @Test
// // void canGetAllEmails() throws Exception {

// // // given
// // String ownerRef = String.format("%s %s", faker.name().firstName(),
// // faker.name().lastName());
// // String emailTo = String.format("%s@gmail.com",
// // StringUtils.trimAllWhitespace(faker.name().firstName()));
// // String emailFrom = String.format("%s@gmail.com",
// // StringUtils.trimAllWhitespace(faker.name().firstName()));
// // String subject = String.format("%s %s", faker.name().firstName());
// // String text = String.format("%s %s", faker.name().firstName(),
// // faker.name().lastName());

// // Email email = new Email(ownerRef, emailTo, emailFrom, subject, text);

// // // when
// // ResultActions resultActions =
// //
// //
// mockMvc.perform(post("/api/v1/students").contentType(MediaType.APPLICATION_JSON)
// // .content(objectMapper.writeValueAsString(email)));
// // // then
// // resultActions.andExpect(status().isOk());
// // List<Email> emaiils = studentRepository.findAll();
// //
// //
// assertThat(students).usingElementComparatorIgnoringFields("id").contains(student);

// // }
// }