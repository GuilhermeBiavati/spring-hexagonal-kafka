package com.example.demo.adapters.inbound.controllers;

import com.example.demo.adapters.dtos.EmailDto;
import com.example.demo.application.domain.Email;
import com.example.demo.application.ports.EmailServicePort;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

@RestController
public class EmailController {

    private EmailServicePort emailServicePort;

    public EmailController(EmailServicePort emailService) {
        this.emailServicePort = emailService;
    }

    @PostMapping("/sending-topic")
    public ResponseEntity<String> sendingKafka(@RequestBody @Valid EmailDto emailDto) {
        try {
            emailServicePort.sendKafka(emailDto.toEntity());
            return new ResponseEntity<>("Mensagem enviada com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao enviar mensagem", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto) {

        Email email = emailServicePort.sendEmail(emailDto.toEntity());

        // BeanUtils.copyProperties(emailDto, email);
        // return new ResponseEntity<>(emailServicePort.sendEmail(email),
        // HttpStatus.CREATED);

        return ResponseEntity.status(HttpStatus.CREATED).body(email);
    }

    @GetMapping("/emails")
    public ResponseEntity<Page<Email>> getAllEmails(
            @PageableDefault(page = 0, size = 5, sort = "emailId", direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            Page<Email> emailList = emailServicePort.findAll(pageable);
            return ResponseEntity.ok().body(emailList);
        } catch (Exception e) {

        }

        return null;
    }

    @GetMapping("/emails/{emailId}")
    public ResponseEntity getOneEmail(@PathVariable(value = "emailId") UUID emailId) {

        try {
            return this.emailServicePort.findById(emailId).map(record -> ResponseEntity.ok().body(record))
                    .orElse(ResponseEntity.notFound().build());

        } catch (Exception e) {

        }

        return null;
        // Optional<Email> emailModelOptional = emailServicePort.findById(emailId);
        // if (!emailModelOptional.isPresent()) {
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found.");
        // } else {
        // return ResponseEntity.status(HttpStatus.OK).body(emailModelOptional.get());
        // }
    }
}