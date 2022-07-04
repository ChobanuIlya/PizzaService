package com.example.pizzaservice.utility;

import com.example.pizzaservice.entity.Pizza;

import java.util.HashMap;

public class InfoPack {
    private Integer totalPrice;
    private Pizza customerPizza;


    public InfoPack(Integer totalPrice, Pizza customerPizza) {
        this.totalPrice = totalPrice;
        this.customerPizza = customerPizza;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }


    public Pizza getCustomerPizza() {
        return customerPizza;
    }

    public void setCustomerPizza(Pizza customerPizza) {
        this.customerPizza = customerPizza;
    }
}
