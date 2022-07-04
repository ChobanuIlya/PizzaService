package com.example.pizzaservice.controller;

import com.example.pizzaservice.entity.Customer;
import com.example.pizzaservice.repository.CustomerRepository;
import com.example.pizzaservice.service.CustomerService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class RegistrationController {
    private final CustomerService customerService;


    public RegistrationController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("phone_number") String phoneNumber, @ModelAttribute("password") String password,
                          @ModelAttribute("first_name") String firstName, @ModelAttribute("last_name") String lastName,
                          @ModelAttribute("address") String address, @ModelAttribute("email") String email,
                          @ModelAttribute("bday") Date bday, Map<String, Object> model) {
        Customer customer = customerService.newCustomer(phoneNumber, password, firstName, lastName, address, email, bday, model);
        if (customer != null){
            model.put("message", "Customer exists!");
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Authentication authentication){
        if (authentication != null){
            return "redirect:/main";
        }
        return "login";
    }
}
