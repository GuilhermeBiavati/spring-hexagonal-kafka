
package com.example.demo.application.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Pattern;

import com.example.demo.application.domain.enums.StatusEmail;

public class Email {
    private UUID emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

    public Email() {
        this.generateUUID();
    }

    public Email(UUID emailId, String ownerRef, String emailFrom, String emailTo, String subject, String text,
            LocalDateTime sendDateEmail) {
        this.setEmailId(emailId);
        this.setOwnerRef(ownerRef);
        this.setEmailFrom(emailFrom);
        this.setEmailTo(emailTo);
        this.setSubject(subject);
        this.setText(text);
        this.setSendDateEmail(sendDateEmail);
    }

    public Email(UUID emailId, String ownerRef, String emailFrom, String emailTo, String subject, String text) {
        this.setEmailId(emailId);
        this.setOwnerRef(ownerRef);
        this.setEmailFrom(emailFrom);
        this.setEmailTo(emailTo);
        this.setSubject(subject);
        this.setText(text);
    }

    public Email(UUID emailId, String ownerRef, String emailFrom, String emailTo, String subject, String text,
            StatusEmail statusEmail) {
        this.setEmailId(emailId);
        this.setOwnerRef(ownerRef);
        this.setEmailFrom(emailFrom);
        this.setEmailTo(emailTo);
        this.setSubject(subject);
        this.setText(text);
        this.setStatusEmail(statusEmail);
        this.setSendDateEmail(sendDateEmail);
    }

    public Email(UUID emailId, String ownerRef, String emailFrom, String emailTo, String subject, String text,
            LocalDateTime sendDateEmail, StatusEmail statusEmail) {
        this.setEmailId(emailId);
        this.setOwnerRef(ownerRef);
        this.setEmailFrom(emailFrom);
        this.setEmailTo(emailTo);
        this.setSubject(subject);
        this.setText(text);
        this.setStatusEmail(statusEmail);
        this.setSendDateEmail(sendDateEmail);
    }

    public Email(String ownerRef, String emailFrom, String emailTo, String subject, String text,
            LocalDateTime sendDateEmail, StatusEmail statusEmail) {
        this.generateUUID();
        this.setOwnerRef(ownerRef);
        this.setEmailFrom(emailFrom);
        this.setEmailTo(emailTo);
        this.setSubject(subject);
        this.setText(text);
        this.setStatusEmail(statusEmail);
        this.setSendDateEmail(sendDateEmail);
    }

    public Email(String ownerRef, String emailFrom, String emailTo, String subject, String text) {
        this.generateUUID();
        this.setOwnerRef(ownerRef);
        this.setEmailFrom(emailFrom);
        this.setEmailTo(emailTo);
        this.setSubject(subject);
        this.setText(text);
    }

    public UUID getEmailId() {
        return emailId;
    }

    public void setEmailId(UUID emailId) {
        if (emailId == null)
            throw new IllegalArgumentException("emailId is marked non-null, but is null");
        if (!this.isValidUUID(emailId.toString()))
            throw new IllegalArgumentException("emailId is marked as valid uuid, but is not valid");
        this.emailId = emailId;
    }

    protected Boolean isValidUUID(String _id) {
        if (_id == null) {
            return false;
        }

        Pattern UUID_REGEX_PATTERN = Pattern.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");
        return UUID_REGEX_PATTERN.matcher(_id).matches();
    }

    protected UUID generateUUID() {
        this.emailId = UUID.randomUUID();
        return this.emailId;
    }

    public String getOwnerRef() {
        return ownerRef;
    }

    public void setOwnerRef(String ownerRef) {
        if (ownerRef == null)
            throw new IllegalArgumentException("ownerRef is marked non-null, but is null");
        if (ownerRef.length() == 0)
            throw new IllegalArgumentException("ownerRef is marked not-blank but is not-blank");
        this.ownerRef = ownerRef;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        if (emailFrom == null)
            throw new IllegalArgumentException("emailFrom is marked non-null, but is null");
        if (emailFrom.length() == 0)
            throw new IllegalArgumentException("emailFrom is marked not-blank but is not-blank");
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        if (emailTo == null)
            throw new IllegalArgumentException("emailTo is marked non-null, but is null");
        if (emailTo.length() == 0)
            throw new IllegalArgumentException("emailTo is marked not-blank but is not-blank");
        this.emailTo = emailTo;
    }

    public String getSubject() {

        return subject;
    }

    public void setSubject(String subject) {
        if (subject == null)
            throw new IllegalArgumentException("subject is marked non-null, but is null");
        if (subject.length() == 0)
            throw new IllegalArgumentException("subject is marked not-blank but is not-blank");
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text == null)
            throw new IllegalArgumentException("text is marked non-null, but is null");
        if (text.length() == 0)
            throw new IllegalArgumentException("text is marked not-blank but is not-blank");
        this.text = text;
    }

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }
}
