package com.online.test_trail.service.impl;

import com.online.test_trail.dto.IngredientDto;
import com.online.test_trail.entity.Content;
import com.online.test_trail.entity.Ingredient;
import com.online.test_trail.repo.IngredientRepo;
import com.online.test_trail.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepo ingredientRepository;


    @Override
    public void save(IngredientDto ingredientDto) {

        Ingredient ingredient;

        if (ingredientDto.getId() != null) {
            ingredient = ingredientRepository.findById(ingredientDto.getId()).get();
        } else {
            ingredient = new Ingredient();
        }

        ingredient.setIngredientName(ingredientDto.getIngredientName());
        ingredient.setIngredientQuantity(Integer.parseInt(ingredientDto.getIngredientQuantity()));
        ingredient.setIngredientFraction(Double.parseDouble(ingredientDto.getIngredientFraction()));
        ingredient.setIngredientUnit(ingredientDto.getIngredientUnit());

        ingredient = ingredientRepository.save(ingredient);

    }


    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Content findById(Long id) {
        return null;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> getIngredientsByName(String name) {
        return ingredientRepository.findByIngredientName(name);
    }

}
