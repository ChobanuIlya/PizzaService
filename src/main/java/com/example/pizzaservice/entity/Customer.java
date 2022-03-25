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
    @Column(name = "CUSTOMER_ADDRESS")
    private String address;
    @Column(name = "CUSTOMER_PHONE_NUMBER")
    private String phoneNumber; //TODO
    @Column(name = "CUSTOMER_EMAIL")
    private String email;
    @Column(name = "CUSTOMER_REGISTERED")
    private Boolean registered;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
