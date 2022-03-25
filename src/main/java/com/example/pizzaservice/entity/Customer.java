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

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }
}
