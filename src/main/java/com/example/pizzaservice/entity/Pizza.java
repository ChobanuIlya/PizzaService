package com.example.pizzaservice.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "pizza_id"))
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "PIZZA_NAME")
    private String pizzaName;
    @Column(name = "PIZZA_DIAMETER")
    private Diameter diameter;
    @ElementCollection
    @Column(name = "PIZZA_INGRIDIENTS")
    private List<Ingredients> ingredients;
    @Column(name = "PIZZA_WEIGHT")
    private Integer weight;
    @Column(name = "PIZZA_DOUGH_TYPE")
    private DoughType doughType;
    @Column(name = "PIZZA_PRICE")
    private Integer price;

    public enum Diameter {
        SMALL(25),
        MEDIUM(30),
        LARGE(35);

        private final int value;

        Diameter(final int newValue){
            value = newValue;
        }

        public int getValue(){
            return value;
        }
    }

    public enum Ingredients{
        MOZZARELLA,
        CHEDDAR,
        BLUE_CHEESE,
        CHICKEN,
        BEEF,
        SAUSAGE,
        CHORIZO,
        MUSHROOM,
        ONION,
        PICKLES,
        OLIVES,
        WHITE_SAUCE,
        TOMATO_SAUCE
    }

    public enum DoughType{
        THIN,
        THICK,
        HOTDOG,
        CHEESY
    }

    public enum PizzaDefault{
        MARGARITA,
        FOUR_CHEESE,
        VILLAGER,
        SUPER_MEAT,
        DIABLO
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Diameter getDiameter() {
        return diameter;
    }

    public void setDiameter(Diameter diameter) {
        this.diameter = diameter;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public DoughType getDoughType() {
        return doughType;
    }

    public void setDoughType(DoughType doughType) {
        this.doughType = doughType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
