package com.online.test_trail.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "content")
public class Content {

    @Id
    @SequenceGenerator(name = "contents_seq_gen", sequenceName = "contents_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "contents_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "recipe_title", nullable = false)
    private String recipeTitle;

    @Column(name = "recipe_description", length = 200)
    private String recipeDescription;

    @Column(name = "prep_time_hours")
    private Integer preparationTimeHours;

    @Column(name = "prep_time_minutes")
    private Integer preparationTimeMinutes;

    @Column(name = "quantity_number")
    private Integer recipeQuantityNumber;

    @Column(name = "quantity_type")
    private String recipeQuantityType;

    @Column(name = "category_type")
    private String categoryType;

    @Column(name = "step_description", length = 5000)
    private String stepDescription;

    @Column(name = "recipe_photo")
    private String recipePhoto;

    @Column(name="ingredient_list")
    private String incredientList;

}
