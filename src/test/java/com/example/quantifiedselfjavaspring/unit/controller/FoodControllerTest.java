package com.example.quantifiedselfjavaspring.unit.controller;

import com.example.quantifiedselfjavaspring.food.controller.FoodController;
import com.example.quantifiedselfjavaspring.food.entity.Food;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;


@RunWith(SpringRunner.class)
@WebMvcTest(FoodController.class)
public class FoodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FoodController foodController;

    @MockBean
    HttpServletResponse res;


    @Test
    public void getAllFoods() throws Exception {
        Food food = new Food();
        food.setName("Young Tycoon");
        food.setCalories(9001L);
        food.setId(1L);

        List<Food> allFoods = Collections.singletonList(food);

        given(foodController.getAllFoods()).willReturn(allFoods);

        mockMvc.perform(get("/api/v1/foods"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(food.getName())))
                .andExpect(jsonPath("$[0].calories", is(9001)));
    }

    @Test
    public void getFoodById() throws Exception {
        Food food = new Food();
        food.setId(3L);
        food.setCalories(120L);
        food.setName("Peanuts");

        given(foodController.getFoodById(food.getId(), res)).willReturn(food);

        mockMvc.perform(get("/api/v1/foods/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.name", is(food.getName())))
                .andExpect(jsonPath("$.calories", is(90)));
    }

}
