// package com.example.demo.adapters.outbound.persistence.entities;

// import java.time.LocalDateTime;
// import java.util.UUID;
// import lombok.Data;

// import javax.persistence.*;
// import java.io.Serializable;
// import com.example.demo.application.domain.enums.StatusEmail;

// @Data
// @Entity
// @Table(name = "TB_EMAIL")
// public class EmailEntity implements Serializable {
// private static final long serialVersionUID = 1L;

// @Id
// @GeneratedValue(strategy = GenerationType.AUTO)
// private UUID emailId;
// private String ownerRef;
// private String emailFrom;
// private String emailTo;
// private String subject;
// @Column(columnDefinition = "TEXT")
// private String text;
// private LocalDateTime sendDateEmail;
// private StatusEmail statusEmail;
// }
