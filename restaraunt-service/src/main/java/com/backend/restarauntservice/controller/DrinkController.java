package com.backend.restarauntservice.controller;

import com.backend.restarauntservice.dto.DrinkDto;
import com.backend.restarauntservice.entity.Drink;
import com.backend.restarauntservice.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant/drinks")
public class DrinkController {
    private final DrinkService drinkService;

    @GetMapping
    public List<Drink> getAllDrinks() {
        return drinkService.getAllDrinks();
    }

    @GetMapping("{id}")
    public Drink getDrinkById(@PathVariable Long id) {
        return drinkService.getDrinkById(id);
    }

    @PostMapping
    public Drink createDrink(@RequestBody DrinkDto drink) {
        return drinkService.saveDrink(drink);
    }

    @PutMapping("{id}")
    public Drink updateDrink(@RequestBody DrinkDto drink, @PathVariable Long id) {
        return drinkService.updateDrink(id, drink);
    }

    @DeleteMapping("{id}")
    public String deleteDrink(@PathVariable Long id) {
        return drinkService.deleteDrink(id);
    }
}
