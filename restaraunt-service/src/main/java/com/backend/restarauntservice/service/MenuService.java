package com.backend.restarauntservice.service;

import com.backend.restarauntservice.dto.MenuDto;
import com.backend.restarauntservice.entity.Drink;
import com.backend.restarauntservice.entity.Food;
import com.backend.restarauntservice.entity.Menu;
import com.backend.restarauntservice.repository.MenuRepository;
import jakarta.ws.rs.InternalServerErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional(readOnly = true)
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Transactional
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Transactional
    public Menu updateById(MenuDto menuDto, Long id) {
        Menu menu = menuRepository.findById(id).orElse(null);

        if (menu != null) {
            menu.setName(menuDto.getName());
            menu.setDescription(menuDto.getDescription());

            if (menuDto.getFoods() != null) {
                for (Food food : menuDto.getFoods()) {
                    menu.getFoods().add(food);
                }
            }

            if (menuDto.getDrinks() != null) {
                for (Drink drink : menuDto.getDrinks()) {
                    menu.getDrinks().add(drink);
                }
            }
            return menuRepository.save(menu);
        } else {
            throw new InternalServerErrorException("Menu not found");
        }
    }

    @Transactional
    public String deleteMenuById(Long id) {
        menuRepository.deleteById(id);
        return "Menu deleted";
    }
}
