package com.example.pizzaservice.service;

import com.example.pizzaservice.entity.Customer;
import com.example.pizzaservice.exception.InvalidEmailException;
import com.example.pizzaservice.exception.InvalidPhoneNumberException;
import com.example.pizzaservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer newCustomer(Customer customer) throws RuntimeException {
        if (isPhoneNumberTaken(customer)) {
            throw new InvalidPhoneNumberException("This phone number is already taken!");
        }
        if (isEmailTaken(customer)) {
            throw new InvalidEmailException("This email is already taken!");
        }
        return customerRepository.save(customer);
    }

    public void login(Customer customer, HttpServletRequest request, HttpServletResponse response) {
        if (isPhoneNumberTaken(customer)) {
            HttpSession session = request.getSession();
            session.setAttribute("first_name", customer.getFirstName());
            session.setAttribute("phone_number", customer.getPhoneNumber());
        }
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public boolean isPhoneNumberTaken(Customer customer) {
        List<Customer> list = findAllCustomers();
        for (Customer customer1 : list) {
            if (customer1.getPhoneNumber().equals(customer.getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmailTaken(Customer customer) {
        List<Customer> list = findAllCustomers();
        for (Customer customer1 : list) {
            if (customer1.getEmail().equals(customer.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
