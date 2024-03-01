package com.online.test_trail;
import com.online.test_trail.entity.Content;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ContentRepoTest {

    @Mock
    private ContentRepo contentRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllByRecipeTitle() {
        // Given
        String recipeTitle = "Test Recipe";
        List<Content> contentList = new ArrayList<>();
        // Add some sample content to the list

        when(contentRepo.findAllByRecipeTitle(recipeTitle)).thenReturn(contentList);

        // When
        List<Content> result = contentRepo.findAllByRecipeTitle(recipeTitle);

        // Then
        assertEquals(contentList, result);
    }

    @Test
    public void testSearchByCategory() {
        // Given
        String category = "Category";
        List<Content> contentList = new ArrayList<>();
        // Add some sample content to the list

        when(contentRepo.searchByCategory(category)).thenReturn(contentList);

        // When
        List<Content> result = contentRepo.searchByCategory(category);

        // Then
        assertEquals(contentList, result);
    }
}
