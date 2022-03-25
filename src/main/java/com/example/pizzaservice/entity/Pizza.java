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
        OLIVES
    }

    public enum DoughType{
        THIN,
        THICK,
        HOTDOG,
        CHEESY
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
