package com.example.quantifiedselfjavaspring.meal.controller;


import com.example.quantifiedselfjavaspring.meal.entity.Meal;
import com.example.quantifiedselfjavaspring.meal.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/meals", produces = "application/json")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public List<Meal> getAllMeals() {
        return mealService.allMeals();
    }

    @GetMapping("/{meal_id}/foods")
    public Meal getMealById(@PathVariable(value = "meal_id") Long mealId, HttpServletResponse res) {
        Optional<Meal> meal = Optional.ofNullable(mealService.findMealById(mealId));
        if (meal.isPresent()) return meal.get();
        else {
            res.setStatus(SC_NOT_FOUND);
            return null;
        }
    }
}
