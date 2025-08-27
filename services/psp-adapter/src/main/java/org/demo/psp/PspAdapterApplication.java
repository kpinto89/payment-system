package org.demo.psp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/psp")
public class PspAdapterApplication {
    public static void main(String[] args) {
        SpringApplication.run(PspAdapterApplication.class, args);
    }

    @GetMapping("/health")
    public String health() {
        return "PSP Adapter is running!";
    }
}