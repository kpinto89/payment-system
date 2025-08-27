package org.demo.payments.client;

import org.demo.common.model.Payment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class PspClient {

    private final RestTemplate restTemplate;

    public PspClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String processPayment(Payment payment) {
        // call PSP Adapter endpoint
        Map<String, String> response = restTemplate.postForObject(
                "http://localhost:8081/psp/pay",
                payment,
                Map.class
        );

        return response != null ? response.get("referenceId") : null;
    }
}