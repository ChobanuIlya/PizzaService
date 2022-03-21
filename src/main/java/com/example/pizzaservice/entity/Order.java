package com.example.pizzaservice.entity;

import javax.persistence.*;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "order_id"))
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
