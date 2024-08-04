package com.ajay.webtest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ValidationException;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;



@Configuration
public class Gsonhelper {
    private final ObjectMapper objectMapper;

    public Gsonhelper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String toJsonString(Object object) {
        try {
          return   objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException exception){
            Mono.error(new ValidationException("invalid object"));
        }
        return "";
    }
}
