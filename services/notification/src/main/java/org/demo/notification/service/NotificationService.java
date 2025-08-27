package org.demo.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    @KafkaListener(topics = "payment-events", groupId = "notify-service")
    public void onPaymentEvent(String message) {
        log.info("Notification sent to customer: {}", message);
    }
}
