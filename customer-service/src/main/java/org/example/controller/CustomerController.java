package org.example.controller;

import org.example.domain.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.service.impl.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerServiceImpl customerService) {

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi";
    }

    @PostMapping
    public void registryNewCustomerRequest(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new customer registry {}", customerRegistrationRequest);
    }
}
