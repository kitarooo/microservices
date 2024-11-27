package com.backend.restarauntservice.service;

import com.backend.restarauntservice.dto.FoodDto;
import com.backend.restarauntservice.entity.Food;

import java.util.List;

public interface FoodService {
    String createFood(FoodDto food);
    Food getFood(Long foodId);
    List<Food> getFoods();
    String updateFood(Long foodId, FoodDto food);
    String deleteFood(Long foodId);
}
