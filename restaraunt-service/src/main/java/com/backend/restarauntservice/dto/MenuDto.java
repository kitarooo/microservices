package com.backend.restarauntservice.dto;

import com.backend.restarauntservice.entity.Drink;
import com.backend.restarauntservice.entity.Food;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuDto {
    String name;
    String description;
    List<Food> foods;
    List<Drink> drinks;
}
