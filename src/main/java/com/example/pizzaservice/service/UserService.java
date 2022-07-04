package com.example.pizzaservice.service;

import com.example.pizzaservice.entity.Customer;
import com.example.pizzaservice.utility.Role;
import com.example.pizzaservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        Customer customer = customerRepository.findCustomerByPhoneNumber(phoneNumber);
        if (customer == null)
            throw new UsernameNotFoundException(phoneNumber + " not found");

        List<GrantedAuthority> roles = List.of(new SimpleGrantedAuthority(Role.USER.toString()));

        return new User(customer.getPhoneNumber(), customer.getPassword(), roles);// TODO: 14.06.2022 check if admin is required
    }
}