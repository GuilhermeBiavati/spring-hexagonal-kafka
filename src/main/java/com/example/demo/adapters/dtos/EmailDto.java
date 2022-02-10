package com.example.demo.adapters.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

import com.example.demo.application.domain.Email;
// import com.github.dozermapper.core.DozerBeanMapperBuilder;
// import com.github.dozermapper.core.Mapper;

import org.modelmapper.ModelMapper;

// @Data
@Getter
@Setter
@EqualsAndHashCode
public class EmailDto {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String ownerRef;
    @NotBlank
    @javax.validation.constraints.Email
    private String emailFrom;
    @NotBlank
    @javax.validation.constraints.Email
    private String emailTo;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;

    public Email toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        Email entity = modelMapper.map(this, Email.class);
        return entity;
    }

}
