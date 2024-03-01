package com.online.test_trail;
import com.online.test_trail.dto.IngredientDto;
import com.online.test_trail.entity.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class IngredientServiceTest {

    @Mock
    private IngredientRepository ingredientRepository;

    @InjectMocks
    private IngredientServiceImpl ingredientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveIngredient() {
        // Given
        IngredientDto ingredientDto = new IngredientDto();
        // Set up ingredientDto properties

        // When
        ingredientService.save(ingredientDto);

        // Then
        verify(ingredientRepository, times(1)).save(any(Ingredient.class));
    }

    @Test
    public void testFindAll() {
        // Given
        List<Ingredient> ingredientList = new ArrayList<>();
        // Add some sample ingredients to the list

        when(ingredientRepository.findAll()).thenReturn(ingredientList);

        // When
        List<Ingredient> result = ingredientService.findAll();

        // Then
        assertEquals(ingredientList, result);
    }

    @Test
    public void testGetAll() {
        // Given
        List<Ingredient> ingredientList = new ArrayList<>();
        // Add some sample ingredients to the list

        when(ingredientRepository.findAll()).thenReturn(ingredientList);

        // When
        List<Ingredient> result = ingredientService.getAll();

        // Then
        assertEquals(ingredientList, result);
    }

    @Test
    public void testFindById() {
        // Given
        Long id = 1L;
        Ingredient ingredient = new Ingredient();
        // Mocking the behavior of the repository method
        when(ingredientRepository.findById(id)).thenReturn(Optional.of(ingredient));

        // When
        Ingredient result = ingredientService.findById(id);

        // Then
        assertEquals(ingredient, result);
    }

    @Test
    public void testGetAllIngredients() {
        // Given
        List<Ingredient> ingredientList = new ArrayList<>();
        // Add some sample ingredients to the list

        when(ingredientRepository.findAll()).thenReturn(ingredientList);

        // When
        List<Ingredient> result = ingredientService.getAllIngredients();

        // Then
        assertEquals(ingredientList, result);
    }

    @Test
    public void testGetIngredientsByName() {
        // Given
        String name = "ingredientName";
        List<Ingredient> ingredientList = new ArrayList<>();
        // Add some sample ingredients to the list

        when(ingredientRepository.findByName(name)).thenReturn(ingredientList);

        // When
        List<Ingredient> result = ingredientService.getIngredientsByName(name);

        // Then
        assertEquals(ingredientList, result);
    }
}
