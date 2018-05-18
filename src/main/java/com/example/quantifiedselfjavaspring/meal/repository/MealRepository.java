package com.example.quantifiedselfjavaspring.meal.repository;

import com.example.quantifiedselfjavaspring.meal.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
}
