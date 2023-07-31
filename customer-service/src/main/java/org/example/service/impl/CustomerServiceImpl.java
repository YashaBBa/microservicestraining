package org.example.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.domain.Customer;
import org.example.domain.CustomerRegistrationRequest;
import org.example.dto.FraudCheckResponse;
import org.example.repo.CustomerRepository;
import org.example.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final RestTemplate restTemplate;
    private final CustomerRepository customerRepository;


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
        customerRepository.saveAndFlush(customer);
        // todo:: check if customer is fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://GATEWAY/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if(fraudCheckResponse.getIsFraudster()){
            throw new IllegalStateException("Fraudster");
        }


    }
}
