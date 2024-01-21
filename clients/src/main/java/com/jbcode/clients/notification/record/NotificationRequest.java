package com.jbcode.clients.notification.record;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}
