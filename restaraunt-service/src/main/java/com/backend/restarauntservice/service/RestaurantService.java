package com.backend.restarauntservice.service;

import com.backend.restarauntservice.dto.RestaurantDto;
import com.backend.restarauntservice.entity.Menu;
import com.backend.restarauntservice.entity.Restaurant;
import com.backend.restarauntservice.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDto.getName());
        restaurant.setAddress(restaurantDto.getAddress());
        restaurant.setPhoneNumber(restaurantDto.getPhoneNumber());
        restaurant.setMenu(restaurantDto.getMenu());
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(RestaurantDto restaurantDto, Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElse(null);

        if (restaurant != null) {
            restaurant.setName(restaurantDto.getName());
            restaurant.setAddress(restaurantDto.getAddress());
            restaurant.setPhoneNumber(restaurantDto.getPhoneNumber());
            for (Menu menu : restaurantDto.getMenu()) {
                restaurant.getMenu().add(menu);
            }
            return restaurantRepository.save(restaurant);
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public String deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
        return "Restaurant with id " + id + " was deleted";
    }
}
