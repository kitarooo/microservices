package com.backend.restarauntservice.controller;

import com.backend.restarauntservice.dto.FoodDto;
import com.backend.restarauntservice.entity.Food;
import com.backend.restarauntservice.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant/foods")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping
    public ResponseEntity<List<Food>> getFoods() {
        return ResponseEntity.ok(foodService.getFoods());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getFood(id));
    }

    @PostMapping
    public ResponseEntity<String> createFood(@RequestBody FoodDto food) {
        return ResponseEntity.ok(foodService.createFood(food));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateFood(@PathVariable Long id, @RequestBody FoodDto food) {
        return ResponseEntity.ok(foodService.updateFood(id, food));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.deleteFood(id));
    }
}
