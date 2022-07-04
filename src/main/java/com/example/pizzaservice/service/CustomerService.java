package com.example.pizzaservice.service;

import com.example.pizzaservice.entity.Customer;
import com.example.pizzaservice.entity.Order;
import com.example.pizzaservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer newCustomer(String phoneNumber, String password, String firstName, String lastName,
                                String address, String email, Date bday, Map<String, Object> model){
        Customer customerFromDb = customerRepository.findCustomerByPhoneNumber(phoneNumber);
        if (customerFromDb != null) {
            model.put("message", "Customer exists!");
        }
        Customer customer = new Customer();
        List<Order> orders = new ArrayList<>();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPassword(passwordEncoder.encode(password));
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        customer.setEmail(email);
        customer.setBirthday(bday);
        customer.setOrder(orders);
        customerRepository.save(customer);
        return customerFromDb;
    }

    public void updateCustomer(String password, String firstName, String lastName,
                               String address, String email, Authentication authentication){
        customerRepository.findById(customerRepository.findCustomerByPhoneNumber(authentication.getName()).getId())
                .map(entity -> {
                    entity.setFirstName(firstName);
                    entity.setLastName(lastName);
                    entity.setAddress(address);
                    entity.setEmail(email);
                    if (!password.isEmpty()) {
                        entity.setPassword(passwordEncoder.encode(password));
                    }
                    return customerRepository.save(entity);
                });
    }
}
