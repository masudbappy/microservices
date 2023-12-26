package com.masudbappy.clients.fraud.record;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}
