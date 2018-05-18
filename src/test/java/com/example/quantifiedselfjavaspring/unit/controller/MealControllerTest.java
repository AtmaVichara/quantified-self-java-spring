package com.example.quantifiedselfjavaspring.unit.controller;

import com.example.quantifiedselfjavaspring.meal.controller.MealController;
import com.example.quantifiedselfjavaspring.food.entity.Food;
import com.example.quantifiedselfjavaspring.meal.entity.Meal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@WebMvcTest(MealController.class)
public class MealControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MealController mealController;

    @Test
    public void getAllMeals() throws Exception {
        Meal meal = new Meal();
        meal.setName("Second Breakfast");
        meal.setId(1L);
        Food firstFood = new Food();
        firstFood.setAttrs("Carrots", 45L);
        Food secondFood = new Food();
        secondFood.setAttrs("Potatoes", 120L);

        List<Meal> allMealls = Collections.singletonList(meal);

        given(mealController.getAllMeals()).willReturn(allMealls);

        mockMvc.perform()

    }
}
