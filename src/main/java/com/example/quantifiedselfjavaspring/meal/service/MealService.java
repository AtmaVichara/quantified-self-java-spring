package com.example.quantifiedselfjavaspring.meal.service;


import com.example.quantifiedselfjavaspring.meal.entity.Meal;
import com.example.quantifiedselfjavaspring.meal.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    MealRepository mealRepository;

    public List<Meal> allMeals() {
        return mealRepository.findAll();
    }

    public Meal findMealById(Long id) {
        Optional<Meal> meal = mealRepository.findById(id);
        if (meal.isPresent()) {
            return meal.get();
        } else {
            return null;
        }
    }
}
