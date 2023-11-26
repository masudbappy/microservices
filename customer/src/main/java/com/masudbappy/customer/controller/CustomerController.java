package com.masudbappy.customer.controller;

import com.masudbappy.customer.model.Customer;
import com.masudbappy.customer.record.CustomerRegistrationRequest;
import com.masudbappy.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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

    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customer>> getCustomers(){
        log.info("Get All the registered customers {} ");
        List<Customer> customers = customerService.getCustomers();
        return ResponseEntity.ok(customers);
    }

    @DeleteMapping("/deleteCustomers/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Integer id){
        log.info("Customer Deleted Successfully {} ");
        try {
            customerService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
