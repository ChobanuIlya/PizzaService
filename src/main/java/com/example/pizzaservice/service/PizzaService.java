package com.example.pizzaservice.service;

import com.example.pizzaservice.utility.InfoPack;
import com.example.pizzaservice.entity.Pizza;
import com.example.pizzaservice.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public InfoPack addCustomerPizza(Pizza customerPizza, HashMap<Pizza, Integer> cart, Integer totalPrice){
        if (cart.containsKey(customerPizza)) {
            cart.replace(customerPizza, cart.get(customerPizza) + 1);
        } else {
            cart.put(customerPizza, 1);
        }
        totalPrice += customerPizza.getPrice();
        customerPizza = new Pizza();
        return new InfoPack(totalPrice, customerPizza);
    }

    public Integer addPizzaToCart(String pizzaName, Integer totalPrice, HashMap<Pizza, Integer> cart){
        Pizza pizza = pizzaRepository.findPizzaByPizzaName(pizzaName);
        if (cart.containsKey(pizza)) {
            cart.replace(pizza, cart.get(pizza) + 1);
        } else {
            cart.put(pizza, 1);
        }

        totalPrice += pizza.getPrice();
        return totalPrice;
    }


    public Pizza customerPizza(Pizza customerPizza, String pizzaName, Integer diameter, String doughType, String sauce,
                               String ingredient1, String ingredient2, String ingredient3, String ingredient4){
        int customerPizzaPrice = 100;
        List<Pizza.Ingredients> ingredients = new ArrayList<>();
        ingredients.add(Pizza.Ingredients.MOZZARELLA);
        customerPizza.setPizzaName(pizzaName);

        switch (diameter) {
            case 25:
                customerPizzaPrice = customerPizzaPrice - 25;
                customerPizza.setDiameter(Pizza.Diameter.SMALL);
                break;
            case 30:
                customerPizza.setDiameter(Pizza.Diameter.MEDIUM);
                break;
            case 35:
                customerPizza.setDiameter(Pizza.Diameter.LARGE);
                customerPizzaPrice = customerPizzaPrice + 25;
                break;
        }


        switch (doughType) {
            case "Thin":
                customerPizza.setDoughType(Pizza.DoughType.THIN);
                break;
            case "Thick":
                customerPizza.setDoughType(Pizza.DoughType.THICK);
                break;
            case "Hotdog":
                customerPizza.setDoughType(Pizza.DoughType.HOTDOG);
                customerPizzaPrice = customerPizzaPrice + 25;
                break;
            case "Cheesy":
                customerPizza.setDoughType(Pizza.DoughType.CHEESY);
                customerPizzaPrice = customerPizzaPrice + 25;
        }


        switch (sauce){
            case "Tomato Sauce":
                ingredients.add(Pizza.Ingredients.TOMATO_SAUCE);
                break;
            case "White Sauce":
                ingredients.add(Pizza.Ingredients.WHITE_SAUCE);
                break;
        }


        customerPizzaPrice = ingredientPutter(ingredient1, ingredients, customerPizzaPrice);
        customerPizzaPrice = ingredientPutter(ingredient2, ingredients, customerPizzaPrice);
        customerPizzaPrice = ingredientPutter(ingredient3, ingredients, customerPizzaPrice);
        customerPizzaPrice = ingredientPutter(ingredient4, ingredients, customerPizzaPrice);
        customerPizza.setIngredients(ingredients);
        customerPizza.setPrice(customerPizzaPrice);
        customerPizza.setWeight(500);
        return customerPizza;
    }
    public Integer ingredientPutter(String ingredient, List<Pizza.Ingredients> ingredientsList, Integer totalPrice){

        switch (ingredient){
            case "Nothing":
                break;
            case "Cheddar":
                ingredientsList.add(Pizza.Ingredients.CHEDDAR);
                totalPrice = totalPrice + 25;
                break;
            case "Blue Cheese":
                ingredientsList.add(Pizza.Ingredients.BLUE_CHEESE);
                totalPrice = totalPrice + 25;
                break;
            case "Chicken":
                ingredientsList.add(Pizza.Ingredients.CHICKEN);
                totalPrice = totalPrice + 25;
                break;
            case "Beef":
                ingredientsList.add(Pizza.Ingredients.BEEF);
                totalPrice = totalPrice + 25;
                break;
            case "Shrimp":
                ingredientsList.add(Pizza.Ingredients.SHRIMP);
                totalPrice = totalPrice + 35;
                break;
            case "Sausage":
                ingredientsList.add(Pizza.Ingredients.SAUSAGE);
                totalPrice = totalPrice + 25;
                break;
            case "Chorizo":
                ingredientsList.add(Pizza.Ingredients.CHORIZO);
                totalPrice = totalPrice + 25;
                break;
            case "Mushroom":
                ingredientsList.add(Pizza.Ingredients.MUSHROOM);
                totalPrice = totalPrice + 15;
                break;
            case "Onion":
                ingredientsList.add(Pizza.Ingredients.ONION);
                totalPrice = totalPrice + 15;
                break;
            case "Pickles":
                ingredientsList.add(Pizza.Ingredients.BLUE_CHEESE);
                totalPrice = totalPrice + 15;
                break;
            case "Olive":
                ingredientsList.add(Pizza.Ingredients.OLIVES);
                totalPrice = totalPrice + 15;
                break;
            case "Tomatoes":
                ingredientsList.add(Pizza.Ingredients.TOMATOES);
                totalPrice = totalPrice + 15;
                break;
        }
        return totalPrice;
    }
}
