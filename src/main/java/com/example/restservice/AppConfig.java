package com.example.restservice;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${test_val:45}")
    Integer value;

    public Integer getValue() {
        return value;
    }
}
