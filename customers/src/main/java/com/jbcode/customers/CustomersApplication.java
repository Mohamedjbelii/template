package com.jbcode.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.jbcode.customers",
                "com.jbcode.amqp",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.jbcode.clients"
)
public class CustomersApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomersApplication.class, args);
    }

}
