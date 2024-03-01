package com.online.test_trail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDto {

    private Long id;
    private String ingredientName;
    private String ingredientQuantity;
    private String ingredientFraction;
    private String ingredientUnit;
}