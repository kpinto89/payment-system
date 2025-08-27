package org.demo.psp.controller;

import org.demo.common.model.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/psp")
public class PspController {

    @PostMapping("/pay")
    public Map<String, String> pay(@RequestBody Payment payment) {
        return Map.of(
                "referenceId", UUID.randomUUID().toString(),
                "status", "SUCCESS"
        );
    }
}
