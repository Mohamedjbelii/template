package com.jbcode.customers.service;

import com.jbcode.customers.model.Customer;
import com.jbcode.customers.record.CustomerRegistrationRequest;
import com.jbcode.customers.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

        //todo : check if mail is valid
        //todo : check if mail is not taken
        customerRepository.save(customer);
    }
}
