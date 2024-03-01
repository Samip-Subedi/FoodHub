package com.online.test_trail.repo;
import com.online.test_trail.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
    @Query("SELECT i FROM Ingredient i WHERE LOWER(i.ingredientName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Ingredient> findByIngredientName(String keyword);
}
