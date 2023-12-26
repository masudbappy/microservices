package com.masudbappy.customer.service;

import com.masudbappy.customer.model.Customer;
import com.masudbappy.customer.record.CustomerRegistrationRequest;
import com.masudbappy.customer.record.FraudCheckResponse;
import com.masudbappy.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email()).build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponsec = restTemplate.getForObject(
//                "http://localhost:18081/api/v1/fraud-check/{customerId}", this is for without register with eureka
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if (fraudCheckResponsec.isFraudster()){
            throw new IllegalStateException("Fraudster");
        }

    }

    public List<Customer> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
