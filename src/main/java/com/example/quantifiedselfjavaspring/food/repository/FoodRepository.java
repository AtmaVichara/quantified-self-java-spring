package com.example.quantifiedselfjavaspring.food.repository;

import com.example.quantifiedselfjavaspring.food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    public List<Food> findAllByOrderByIdAsc();
}
