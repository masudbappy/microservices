package com.masudbappy.customer.repository;

import com.masudbappy.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Customer repository.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
