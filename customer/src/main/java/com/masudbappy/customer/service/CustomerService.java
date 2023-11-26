package com.masudbappy.customer.service;

import com.masudbappy.customer.model.Customer;
import com.masudbappy.customer.record.CustomerRegistrationRequest;
import com.masudbappy.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email()).build();
        customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
