package com.example.pizzaservice.service;

import com.example.pizzaservice.entity.Customer;
import com.example.pizzaservice.entity.Order;
import com.example.pizzaservice.entity.Pizza;
import com.example.pizzaservice.repository.CustomerRepository;
import com.example.pizzaservice.repository.OrderRepository;
import com.example.pizzaservice.repository.PizzaRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;
    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository, CustomerRepository customerRepository, CustomerRepository customerRepository1) {
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
        this.customerRepository = customerRepository1;
    }

    public void saveOrderForAnon(String firstName, String lastName, String address, String phoneNumber, HashMap<Pizza, Integer> cart, Integer totalPrice){
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setPhoneNumber(phoneNumber);
        Order order = new Order();
        order.setCustomer(customer);
        order.setPizzaList((List<Pizza>) cart.keySet());
        order.setOrderPrice(totalPrice);
        orderRepository.save(order);
    }

    public void saveOrder(Authentication authentication, HashMap<Pizza, Integer> cart, Integer totalPrice){
        Customer customer = customerRepository.findCustomerByPhoneNumber(authentication.getName());
        Order order = new Order();
        List<Order> orders = customer.getOrder();
        order.setOrderPrice(totalPrice);
        order.setCustomer(customer);
        order.setPizzaList((List<Pizza>) cart.keySet());
        orders.add(order);
        customerRepository.findById(customerRepository.findCustomerByPhoneNumber(authentication.getName()).getId())
                .map(entity -> {
                    entity.setOrder(orders);
                    return customerRepository.save(entity);
                });
        orderRepository.save(order);
    }

}
