package com.example.pizzaservice.service;

import com.example.pizzaservice.repository.CustomerRepository;
import com.example.pizzaservice.repository.OrderRepository;
import com.example.pizzaservice.repository.PizzaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;

    public OrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
    }

}
