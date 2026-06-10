package com.rajaayam.rajaayam.controller;

import com.rajaayam.rajaayam.entity.Menu;
import com.rajaayam.rajaayam.repository.MenuRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    private final MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("/api/menu")
    public List<Menu> getMenu() {
        return menuRepository.findAll();
    }
}