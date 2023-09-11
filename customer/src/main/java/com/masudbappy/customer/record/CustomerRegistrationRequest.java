package com.masudbappy.customer.record;

/**
 * The type Customer registration request.
 */
public record CustomerRegistrationRequest(String firstName,
                                          String lastName,
                                          String email) {
}
