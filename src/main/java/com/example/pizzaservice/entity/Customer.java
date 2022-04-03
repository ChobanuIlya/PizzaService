package com.example.pizzaservice.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
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
    @Column(name = "CUSTOMER_PASSWORD")
    private String password;
    @Column(name = "CUSTOMER_ADDRESS")
    private String address;
    @Column(name = "CUSTOMER_PHONE_NUMBER")
    private String phoneNumber; //TODO
    @Column(name = "CUSTOMER_EMAIL")
    private String email;
    @OneToMany
    private List<Order> order;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
