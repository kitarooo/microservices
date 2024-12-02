package com.backend.restarauntservice.controller;

import com.backend.restarauntservice.dto.MenuDto;
import com.backend.restarauntservice.entity.Menu;
import com.backend.restarauntservice.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant/menu")
public class MenuController {
    private final MenuService menuService;

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    @PostMapping
    public Menu addMenu(@RequestBody Menu menu) {
        return menuService.saveMenu(menu);
    }

    @PutMapping("{id}")
    public Menu updateMenu(@PathVariable Long id, @RequestBody MenuDto menu) {
        return menuService.updateById(menu, id);
    }

    @DeleteMapping("{id}")
    public String deleteMenu(@PathVariable Long id) {
        return menuService.deleteMenuById(id);
    }
}
