package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.FraudCheckResponse;
import org.example.service.FraudService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudController {
    private final FraudService fraudService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isCustoemrFraudster(@PathVariable Integer customerId) {
        boolean isFraudulentCustomer = fraudService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);


    }
}
