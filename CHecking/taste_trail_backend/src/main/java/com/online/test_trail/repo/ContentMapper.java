package com.online.test_trail.repo;


import com.online.test_trail.dto.response.ContentResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ContentMapper {

    @Select("select c.id as id,\n" +
            "c.recipe_title as recipeTitle,\n" +
            "c.recipe_description as recipeDescription,\n" +
            "c.prep_time_hours as preparationTimeHours,\n" +
            "c.prep_time_minutes as preparationTimeMinutes,\n" +
            "c.quantity_number as recipeQuantityNumber,\n" +
            "c.quantity_type as recipeQuantityType,\n" +
            "c.category_type categoryType,\n" +
            "c.step_description as stepDescription,\n" +
            "c.recipe_photo as recipePhoto,\n" +
            "c.ingredient_list as ncredientList,\n" +
            "f.is_like as isLike from content c left join favourite f on c.id=f.content_id;")
    List<ContentResponse> findAll();

    @Select("select c.id as id,\n" +
            "c.recipe_title as recipeTitle,\n" +
            "c.recipe_description as recipeDescription,\n" +
            "c.prep_time_hours as preparationTimeHours,\n" +
            "c.prep_time_minutes as preparationTimeMinutes,\n" +
            "c.quantity_number as recipeQuantityNumber,\n" +
            "c.quantity_type as recipeQuantityType,\n" +
            "c.category_type categoryType,\n" +
            "c.step_description as stepDescription,\n" +
            "c.recipe_photo as recipePhoto,\n" +
            "c.ingredient_list as ncredientList,\n" +
            "f.is_like as isLike from content c left join favourite f on c.id=f.content_id where c.recipe_title like CONCAT('%', #{title} , '%')")
    List<ContentResponse> findByTitle(String title);
}
