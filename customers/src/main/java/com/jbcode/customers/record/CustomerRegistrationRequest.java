package com.jbcode.customers.record;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
