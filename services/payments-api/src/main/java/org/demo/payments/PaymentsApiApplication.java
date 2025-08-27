package org.demo.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PaymentsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentsApiApplication.class, args);
    }

    @GetMapping("/health")
    public String health() {
        return "Payments API is up!";
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}