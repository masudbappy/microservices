package com.masudbappy.customer.controller;

import com.masudbappy.customer.record.CustomerRegistrationRequest;
import com.masudbappy.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Customer controller.
 */
@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    /**
     * Register customer.
     *
     * @param customerRegistrationRequest the customer registration request
     */
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info("New customer registration {} ", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
