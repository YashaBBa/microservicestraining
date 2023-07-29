package org.example.controller;

import org.example.domain.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.service.impl.CustomerServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerServiceImpl customerService) {

    @PostMapping
    public void registryNewCustomerRequest(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
      log.info("new customer registry {}",customerRegistrationRequest);
    }
}
