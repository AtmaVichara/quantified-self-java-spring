package com.example.quantifiedselfjavaspring.food.controller;

import com.example.quantifiedselfjavaspring.food.entity.Food;
import com.example.quantifiedselfjavaspring.food.repository.FoodRepository;
import com.example.quantifiedselfjavaspring.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static javax.servlet.http.HttpServletResponse.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/foods", produces = "application/json")
public class FoodController {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    FoodService foodService;

    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.allFoods();
    }

    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable(value = "id") Long foodId, HttpServletResponse res) {
        Optional<Food> food = foodService.findFoodById(foodId);
        if (food.isPresent()) {
            return food.get();
        } else {
            res.setStatus(SC_NOT_FOUND);
            return null;
        }
    }

    @PostMapping
    public Food createFood(@Valid @RequestBody Food food, HttpServletResponse res) {
        res.setStatus(SC_CREATED);
        return foodService.createFood(food);
    }

    @PatchMapping(value = "/{id}")
    public Food updateFood(@PathVariable(value = "id") Long foodId, @Valid @RequestBody Food foodData, HttpServletResponse res) {
        Optional<Food> food = Optional.ofNullable(foodService.updateFood(foodId, foodData));
        if (food.isPresent()) {
            res.setStatus(SC_ACCEPTED);
            return food.get();
        } else {
            res.setStatus(SC_NOT_FOUND);
            return null;
        }
    }

    @DeleteMapping(value = "/{id}")
    public Void deleteFood(@PathVariable(value = "id") Long foodId, HttpServletResponse res) {
        Boolean wasDeleted = foodService.deleteFood(foodId);
        if (wasDeleted) {
            res.setStatus(SC_NO_CONTENT);
            return null;
        } else {
            res.setStatus(SC_NOT_FOUND);
            return null;
        }
    }

}
