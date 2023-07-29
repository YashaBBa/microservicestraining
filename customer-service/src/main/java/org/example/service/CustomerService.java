package org.example.service;

import org.example.domain.Customer;
import org.example.domain.CustomerRegistrationRequest;

public interface CustomerService {
    void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest);
}
