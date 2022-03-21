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
    private String pizzaName;
    private Integer diameter;
    //??
    @ElementCollection
    private List<String> ingredients; //TODO
    private Integer weight;
    private String doughType; //TODO
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
