package com.example.pizzaservice.repository;

import com.example.pizzaservice.entity.Order;
import com.example.pizzaservice.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
