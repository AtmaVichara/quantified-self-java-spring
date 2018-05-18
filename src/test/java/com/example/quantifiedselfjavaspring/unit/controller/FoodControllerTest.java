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
        HttpServletResponse res = new HttpServletResponse() {
            @Override
            public void addCookie(Cookie cookie) {

            }

            @Override
            public boolean containsHeader(String name) {
                return false;
            }

            @Override
            public String encodeURL(String url) {
                return null;
            }

            @Override
            public String encodeRedirectURL(String url) {
                return null;
            }

            @Override
            public String encodeUrl(String url) {
                return null;
            }

            @Override
            public String encodeRedirectUrl(String url) {
                return null;
            }

            @Override
            public void sendError(int sc, String msg) throws IOException {

            }

            @Override
            public void sendError(int sc) throws IOException {

            }

            @Override
            public void sendRedirect(String location) throws IOException {

            }

            @Override
            public void setDateHeader(String name, long date) {

            }

            @Override
            public void addDateHeader(String name, long date) {

            }

            @Override
            public void setHeader(String name, String value) {

            }

            @Override
            public void addHeader(String name, String value) {

            }

            @Override
            public void setIntHeader(String name, int value) {

            }

            @Override
            public void addIntHeader(String name, int value) {

            }

            @Override
            public void setStatus(int sc) {

            }

            @Override
            public void setStatus(int sc, String sm) {

            }

            @Override
            public int getStatus() {
                return 0;
            }

            @Override
            public String getHeader(String name) {
                return null;
            }

            @Override
            public Collection<String> getHeaders(String name) {
                return null;
            }

            @Override
            public Collection<String> getHeaderNames() {
                return null;
            }

            @Override
            public String getCharacterEncoding() {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public ServletOutputStream getOutputStream() throws IOException {
                return null;
            }

            @Override
            public PrintWriter getWriter() throws IOException {
                return null;
            }

            @Override
            public void setCharacterEncoding(String charset) {

            }

            @Override
            public void setContentLength(int len) {

            }

            @Override
            public void setContentLengthLong(long length) {

            }

            @Override
            public void setContentType(String type) {

            }

            @Override
            public void setBufferSize(int size) {

            }

            @Override
            public int getBufferSize() {
                return 0;
            }

            @Override
            public void flushBuffer() throws IOException {

            }

            @Override
            public void resetBuffer() {

            }

            @Override
            public boolean isCommitted() {
                return false;
            }

            @Override
            public void reset() {

            }

            @Override
            public void setLocale(Locale loc) {

            }

            @Override
            public Locale getLocale() {
                return null;
            }
        };

        given(foodController.getFoodById(food.getId(), res)).willReturn(food);

        mockMvc.perform(get("/api/v1/foods/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.name", is(food.getName())))
                .andExpect(jsonPath("$.calories", is(90)));
    }

}
