package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.repo.CustomerRepository;
import org.example.service.CustomerService;
import org.example.service.impl.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;


    @GetMapping("/hi")
    public String sayHi() {
        return "Hi";
    }

    @PostMapping
    public void registryNewCustomerRequest(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new customer registry {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);

    }
}
