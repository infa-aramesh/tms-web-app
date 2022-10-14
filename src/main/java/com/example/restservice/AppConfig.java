package com.example.restservice;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${t_val:45}")
    Integer value;

    @Value("${message:Hello}")
    String message;

    public Integer getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
