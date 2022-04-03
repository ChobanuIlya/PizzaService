package com.example.pizzaservice.service;

import com.example.pizzaservice.repository.PizzaRepository;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
}
