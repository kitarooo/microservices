package com.backend.restarauntservice.service.impl;

import com.backend.restarauntservice.dto.FoodDto;
import com.backend.restarauntservice.entity.Food;
import com.backend.restarauntservice.repository.FoodRepository;
import com.backend.restarauntservice.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Override
    public String createFood(FoodDto foodDto) {
        Food food = new Food();
        food.setName(foodDto.getName());
        food.setDescription(foodDto.getDescription());
        food.setPrice(foodDto.getPrice());
        foodRepository.save(food);

        return "Еда была добавлена";
    }

    @Override
    public Food getFood(Long foodId) {
        return foodRepository.findById(foodId).orElse(null);
    }

    @Override
    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    @Override
    public String updateFood(Long foodId, FoodDto food) {
        Food foodToUpdate = foodRepository.findById(foodId).orElseThrow();

        foodToUpdate.setName(food.getName());
        foodToUpdate.setDescription(food.getDescription());
        foodToUpdate.setPrice(food.getPrice());
        foodRepository.save(foodToUpdate);

        return "Еда была обновлена";
    }

    @Override
    public String deleteFood(Long foodId) {
        foodRepository.deleteById(foodId);
        return "Еда была удалена";
    }
}
