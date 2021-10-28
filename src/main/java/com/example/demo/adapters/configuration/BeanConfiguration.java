package com.example.demo.adapters.configuration;

import com.example.demo.DemoApplication;
import com.example.demo.application.ports.EmailRepositoryPort;
import com.example.demo.application.ports.SendEmailServicePort;
import com.example.demo.application.ports.SendKafkaServicePort;
import com.example.demo.application.services.EmailServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DemoApplication.class)
public class BeanConfiguration {
    @Bean
    EmailServiceImpl emailServiceImpl(EmailRepositoryPort repository, SendEmailServicePort sendEmailServicePort,
            SendKafkaServicePort sendKafkaServicePort) {
        return new EmailServiceImpl(repository, sendEmailServicePort, sendKafkaServicePort);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
