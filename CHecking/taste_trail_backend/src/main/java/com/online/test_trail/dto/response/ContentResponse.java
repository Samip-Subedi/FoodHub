package com.online.test_trail.dto.response;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContentResponse {
    private Long id;

    private String recipeTitle;

    private String recipeDescription;

    private Integer preparationTimeHours;

    private Integer preparationTimeMinutes;

    private Integer recipeQuantityNumber;

    private String recipeQuantityType;

    private String categoryType;

    private String stepDescription;

    private String recipePhoto;

    private String incredientList;

    private boolean isLike;
}
