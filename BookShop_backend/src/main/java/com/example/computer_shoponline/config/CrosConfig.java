package com.example.computer_shoponline.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class CrosConfig {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                .allowedHeaders("*");
    }
}
