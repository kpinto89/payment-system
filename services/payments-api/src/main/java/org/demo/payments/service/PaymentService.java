package org.demo.payments.service;

import org.demo.common.model.Payment;
import org.demo.payments.client.PspClient;
import org.demo.payments.dto.PaymentRequest;
import org.demo.payments.dto.PaymentResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class PaymentService {

    private final PspClient pspClient;
    private final Map<UUID, Payment> paymentStore = new ConcurrentHashMap<>();

    public PaymentService(PspClient pspClient) {
        this.pspClient = pspClient;
    }

    public PaymentResponse initiatePayment(PaymentRequest req) {
        UUID id = UUID.randomUUID();

        Payment payment = new Payment();
        payment.setId(id);
        payment.setCustomerId(req.getCustomerId());
        payment.setAmount(req.getAmount());
        payment.setCurrency(req.getCurrency());
        payment.setMethod(req.getMethod());
        payment.setStatus("PENDING");
        payment.setCreatedAt(LocalDateTime.now());

        paymentStore.put(id, payment);

        // call PSP adapter
        String refId = pspClient.processPayment(payment);
        payment.setReferenceId(refId);
        payment.setStatus("SUCCESS"); // in real-world, async + update later

        return new PaymentResponse(id, payment.getStatus(), refId);
    }

    public Payment getPaymentById(UUID id) {
        return paymentStore.get(id);
    }
}

