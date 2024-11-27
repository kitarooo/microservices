package com.backend.restarauntservice.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    String name;
    String description;
    double price;
}
