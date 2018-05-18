package com.example.quantifiedselfjavaspring.food.service;

import com.example.quantifiedselfjavaspring.food.entity.Food;
import com.example.quantifiedselfjavaspring.food.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;

    public List<Food> allFoods() {
        return foodRepository.findAllByOrderByIdAsc();
    }

    public Optional<Food> findFoodById(Long foodId) {
        return foodRepository.findById(foodId);
    }

    public Food createFood(Food food) {
        Food newFood = foodRepository.save(food);
        return newFood;
    }

    public Food updateFood(Long id, Food foodData) {
        Optional<Food> food = foodRepository.findById(id);
        if (food.isPresent()) {
            food.get().setAttrs(foodData.getName(), foodData.getCalories());
            Food updatedFood = foodRepository.save(food.get());
            return updatedFood;
        } else {
            return null;
        }
    }

    public Boolean deleteFood(Long id) {
        Optional<Food> food = foodRepository.findById(id);
        if (food.isPresent()) {
            foodRepository.delete(food.get());
            return true;
        } else {
            return false;
        }
    }
}
