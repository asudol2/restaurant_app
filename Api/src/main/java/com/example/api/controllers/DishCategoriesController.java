package com.example.api.controllers;

import com.example.api.entities.DishCategory;
import com.example.api.projections.DishCategoryInfo;
import com.example.api.repositories.DishCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequestMapping("/dishCategories")
@RestController
public class DishCategoriesController {
    private final DishCategoriesRepository repository;

    @Autowired
    public DishCategoriesController(DishCategoriesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public List<DishCategory> findAll() {
        return (List<DishCategory>) repository.findAll();
    }

    @GetMapping("mobile")
    public List<DishCategoryInfo> findDishCategoriesInfo() {
        return repository.findByNameNotNull();
    }

    @GetMapping("example")
    public DishCategory getExample() {
        return new DishCategory(1L, "Kategoria", "img/kkn.gif", Collections.emptyList());
    }
}
