package org.demo.payments.dto;

import java.util.UUID;

public class PaymentResponse {
    private UUID paymentId;
    private String status;
    private String referenceId;

    // getters/setters

    public PaymentResponse(UUID paymentId, String status, String referenceId) {
        this.paymentId = paymentId;
        this.status = status;
        this.referenceId = referenceId;
    }
}