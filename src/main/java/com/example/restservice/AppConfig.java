package com.example.restservice;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${t_val:10}")
    Integer value;

    @Value("${message:hello}")
    String message;

    public Integer getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
