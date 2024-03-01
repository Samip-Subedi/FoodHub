package com.online.test_trail.dto;


import org.antlr.v4.runtime.misc.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContentDto {

    private Long id;

    @NotNull
    private String recipeTitle;

    @NotNull
    private String recipeDescription;

    @NotNull
    private Integer preparationTimeHours;

    @NotNull
    private Integer preparationTimeMinutes;

    @NotNull
    private Integer recipeQuantityNumber;

    @NotNull
    private String recipeQuantityType;

    @NotNull
    private String categoryType;

    @NotNull
    private String stepDescription;

    @NotNull
    private String recipePhoto;

    @NotNull
    private String ingredientsList;

}
