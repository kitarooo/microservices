package com.backend.restarauntservice.service;

import com.backend.restarauntservice.dto.FoodDto;
import com.backend.restarauntservice.entity.Food;
import com.backend.restarauntservice.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    @Transactional
    public String createFood(FoodDto foodDto) {
        Food food = new Food();
        food.setName(foodDto.getName());
        food.setDescription(foodDto.getDescription());
        food.setPrice(foodDto.getPrice());
        foodRepository.save(food);

        return "Еда была добавлена";
    }

    @Transactional(readOnly = true)
    public Food getFood(Long foodId) {
        return foodRepository.findById(foodId).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    @Transactional
    public String updateFood(Long foodId, FoodDto food) {
        Food foodToUpdate = foodRepository.findById(foodId).orElseThrow();

        foodToUpdate.setName(food.getName());
        foodToUpdate.setDescription(food.getDescription());
        foodToUpdate.setPrice(food.getPrice());
        foodRepository.save(foodToUpdate);

        return "Еда была обновлена";
    }

    @Transactional
    public String deleteFood(Long foodId) {
        foodRepository.deleteById(foodId);
        return "Еда была удалена";
    }
}
