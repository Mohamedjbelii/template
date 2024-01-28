package com.jbcode.customers.service;

import com.jbcode.amqp.RabbitMQMessageProducer;
import com.jbcode.clients.fraud.interfaces.FraudClient;
import com.jbcode.clients.fraud.record.FraudCheckResponse;
import com.jbcode.clients.notification.interfaces.NotificationClient;
import com.jbcode.clients.notification.record.NotificationRequest;
import com.jbcode.customers.model.Customer;
import com.jbcode.customers.record.CustomerRegistrationRequest;
import com.jbcode.customers.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class CustomerService {
    private final CustomerRepository customerRepository;
    private final NotificationClient notificationClient;
    private final FraudClient fraudClient;

    private final RabbitMQMessageProducer rabbitMQMessageProducer;


    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

        //todo : check if mail is valid
        //todo : check if mail is not taken

        customerRepository.saveAndFlush(customer);
        // todo :check if client is fraudster

        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster())
            throw new IllegalStateException("fraudster");

       // todo : send notification
        // todo: make it async. i.e add to queue
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Amigoscode...",
                        customer.getFirstName())
        );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
