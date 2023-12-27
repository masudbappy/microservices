package com.masudbappy.clients.notification.record;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}
