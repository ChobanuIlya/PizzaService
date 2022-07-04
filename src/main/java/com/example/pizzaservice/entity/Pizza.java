package com.example.pizzaservice.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PIZZAS")
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
    @Column(name = "PIZZA_INGREDIENTS")
    private List<Ingredients> ingredients;
    @Column(name = "PIZZA_WEIGHT")
    private Integer weight;
    @Column(name = "PIZZA_DOUGH_TYPE")
    private DoughType doughType;
    @Column(name = "PIZZA_PRICE")
    private Integer price;

    public Pizza() {
    }

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
        SHRIMP,
        SAUSAGE,
        CHORIZO,
        MUSHROOM,
        ONION,
        PICKLES,
        OLIVES,
        TOMATOES,
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
        THREE_CHEESE,
        VILLAGER,
        SUPER_MEAT,
        DIABLO,
        SEAFARER
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", pizzaName='" + pizzaName + '\'' +
                ", diameter=" + diameter +
                ", ingredients=" + ingredients +
                ", weight=" + weight +
                ", doughType=" + doughType +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(pizzaName, pizza.pizzaName) && Objects.equals(price, pizza.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizzaName, price);
    }

    public int setHashcode(Pizza pizza){
        return Objects.hash(pizza);
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
