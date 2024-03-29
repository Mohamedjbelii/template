package com.jbcode.customers.controller;

import com.jbcode.customers.record.CustomerRegistrationRequest;
import com.jbcode.customers.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
private final CustomerService customerService;
@PostMapping
    public  void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info("customer registration {}",customerRegistrationRequest );
        customerService.registerCustomer(customerRegistrationRequest);
        log.info("removing conflictgit add <conflicted_file(s)>\n" +
                "git commit -m \"Resolve conflicts\"\n");
    }
}
