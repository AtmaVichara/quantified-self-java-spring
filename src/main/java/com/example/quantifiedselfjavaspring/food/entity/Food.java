package com.example.quantifiedselfjavaspring.food.entity;

import com.example.quantifiedselfjavaspring.meal.entity.Meal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "foods")
@EntityListeners(AuditingEntityListener.class)
public class Food implements Serializable {

    @ManyToMany(mappedBy = "foods")
    private List<Meal> meals;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "calories")
    private Long calories;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCalories() {
        return calories;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttrs(String name, Long calories) {
        this.name = name;
        this.calories = calories;
    }
}