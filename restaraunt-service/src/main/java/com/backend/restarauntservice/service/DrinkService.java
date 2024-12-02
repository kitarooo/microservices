package com.backend.restarauntservice.service;

import com.backend.restarauntservice.dto.DrinkDto;
import com.backend.restarauntservice.entity.Drink;
import com.backend.restarauntservice.repository.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkService {

    private final DrinkRepository drinkRepository;
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    public Drink getDrinkById(Long id) {
        return drinkRepository.findById(id).orElse(null);
    }

    public Drink saveDrink(DrinkDto drinkDto) {
        Drink drink = new Drink();
        drink.setName(drinkDto.getName());
        drink.setSize(drinkDto.getSize());
        drink.setPrice(drinkDto.getPrice());

        return drinkRepository.save(drink);
    }

    public Drink updateDrink(Long drinkId, DrinkDto drinkDto) {
        Drink drink = drinkRepository.findById(drinkId).orElse(null);

        if (drink != null) {
            drink.setName(drinkDto.getName());
            drink.setPrice(drinkDto.getPrice());
            drink.setSize(drinkDto.getSize());
            return drinkRepository.save(drink);
        }

        return null;
    }

    public String deleteDrink(Long drinkId) {
        drinkRepository.deleteById(drinkId);

        return "Drink deleted";
    }
}
