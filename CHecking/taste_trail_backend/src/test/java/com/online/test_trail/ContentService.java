package com.online.test_trail;

import com.online.test_trail.dto.ContentDto;
import com.online.test_trail.dto.response.ContentResponse;
import com.online.test_trail.entity.Content;
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

public class ContentServiceTest {

    @Mock
    private ContentRepository contentRepository;

    @InjectMocks
    private ContentServiceImpl contentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Given
        List<Content> contentList = new ArrayList<>();
        // Add some sample content to the list

        when(contentRepository.findAll()).thenReturn(contentList);

        // When
        List<Content> result = contentService.getAll();

        // Then
        assertEquals(contentList, result);
    }

    @Test
    public void testFindAll() {
        // Given
        List<ContentResponse> responseList = new ArrayList<>();
        // Add some sample content responses to the list

        when(contentRepository.findAllResponse()).thenReturn(responseList);

        // When
        List<ContentResponse> result = contentService.findAll();

        // Then
        assertEquals(responseList, result);
    }

    @Test
    public void testSearchByCategory() {
        // Given
        String category = "category";
        List<Content> contentList = new ArrayList<>();
        // Add some sample content to the list

        when(contentRepository.findByCategory(category)).thenReturn(contentList);

        // When
        List<Content> result = contentService.searchByCategory(category);

        // Then
        assertEquals(contentList, result);
    }

    @Test
    public void testFindById() {
        // Given
        Long id = 1L;
        Optional<Content> contentOptional = Optional.of(new Content());
        // Mocking the behavior of the repository method
        when(contentRepository.findById(id)).thenReturn(contentOptional);

        // When
        Optional<Content> result = contentService.findById(id);

        // Then
        assertEquals(contentOptional, result);
    }

    @Test
    public void testSearchByTitle() {
        // Given
        String title = "title";
        List<ContentResponse> responseList = new ArrayList<>();
        // Add some sample content responses to the list

        when(contentRepository.searchByTitle(title)).thenReturn(responseList);

        // When
        List<ContentResponse> result = contentService.searchByTitle(title);

        // Then
        assertEquals(responseList, result);
    }

    @Test
    public void testDeleteById() {
        // Given
        Long id = 1L;

        // When
        contentService.deleteById(id);

        // Then
        verify(contentRepository, times(1)).deleteById(id);
    }

    @Test
    public void testSave() {
        // Given
        ContentDto contentDto = new ContentDto();
        // Set up contentDto properties

        // When
        contentService.save(contentDto);

        // Then
        verify(contentRepository, times(1)).save(any(Content.class));
    }
}
