package com.online.test_trail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReviewRepoTest {

    @Mock
    private ReviewRepo reviewRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetReviewByContentId() {
        // Given
        Long contentId = 1L;
        Integer expectedReview = 5;

        // Mocking the behavior of the repository method
        when(reviewRepo.getReviewByContentId(contentId)).thenReturn(expectedReview);

        // When
        Integer resultReview = reviewRepo.getReviewByContentId(contentId);

        // Then
        assertEquals(expectedReview, resultReview);
    }
}
