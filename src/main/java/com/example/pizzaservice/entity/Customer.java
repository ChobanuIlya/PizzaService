package com.example.pizzaservice.entity;

import javax.persistence.*;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "CUSTOMER_FIRST_NAME")
    private String firstName;
    @Column(name = "CUSTOMER_LAST_NAME")
    private String lastName;
    private String address;
    private String phoneNumber; //TODO

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
