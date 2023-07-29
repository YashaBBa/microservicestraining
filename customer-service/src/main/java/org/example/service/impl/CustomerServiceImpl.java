package org.example.service.impl;

import org.example.domain.Customer;
import org.example.domain.CustomerRegistrationRequest;
import org.example.repo.CustomerRepository;
import org.example.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public record CustomerServiceImpl(CustomerRepository customerRepository) implements CustomerService {


    @Override
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .name(customerRegistrationRequest.name())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

        // todo:: check if email valid
        // todo:: check if email not taken
        // todo:: check if customer already in db
        customerRepository.save(customer);

    }
}
