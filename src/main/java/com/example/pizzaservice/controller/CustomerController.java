package com.example.pizzaservice.controller;

import com.example.pizzaservice.entity.Customer;
import com.example.pizzaservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_XHTML_XML_VALUE)
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer newCustomer(@ModelAttribute Customer customer){
        return customerService.newCustomer(customer);
    }
}
