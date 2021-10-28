
// package com.example.demo;

// import java.util.concurrent.TimeUnit;

// import com.example.demo.adapters.inbound.consumers.EmailConsumer;
// import com.example.demo.adapters.outbound.producers.EmailProducer;
// import com.example.demo.application.domain.Email;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.kafka.test.context.EmbeddedKafka;
// import org.springframework.test.annotation.DirtiesContext;

// @SpringBootTest
// @DirtiesContext
// @EmbeddedKafka(partitions = 1, brokerProperties = {
// "listeners=PLAINTEXT://localhost:9092", "port=9092" })
// class EmbeddedKafkaIntegrationTest {

// @Autowired
// private EmailConsumer consumer;

// @Autowired
// private EmailProducer producer;

// @Value("${test.topic}")
// private String topic;

// @Test
// public void
// givenEmbeddedKafkaBroker_whenSendingtoSimpleProducer_thenMessageReceived()
// throws Exception {

// // given
// // Email email = new Email("Guilherme", "guilhermebiavati@gmail.com",
// // "guilhermebiavati@gmail.com", "subject",
// // "text");

// // producer.sendKafka(email);
// // consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);

// // assertThat(consumer.getLatch().getCount(), equalTo(0L));
// // assertThat(consumer.getPayload(), containsString("embedded-test-topic"));
// }
// }