package com.online.test_trail.service;

import com.online.test_trail.dto.IngredientDto;
import com.online.test_trail.entity.Content;
import com.online.test_trail.entity.Ingredient;

import java.util.List;

public interface IngredientService {


    void save(IngredientDto ingredientDto);

    List<Ingredient> findAll();
    List<Ingredient> getAll();

    Content findById(Long id);
    List<Ingredient> getAllIngredients();

    List<Ingredient> getIngredientsByName(String name);

}
