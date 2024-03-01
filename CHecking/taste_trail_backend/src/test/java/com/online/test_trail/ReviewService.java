package com.online.test_trail;
import com.online.test_trail.dto.ReviewDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveReview() {
        // Given
        ReviewDto reviewDto = new ReviewDto();
        // Set up reviewDto properties

        // When
        reviewService.save(reviewDto);

        // Then
        verify(reviewRepository, times(1)).save(any(Review.class));
    }

    @Test
    public void testGetReviewByContentId() {
        // Given
        Long contentId = 1L;
        Integer expectedReview = 5;

        // Mocking the behavior of the repository method
        when(reviewRepository.getReviewByContentId(contentId)).thenReturn(expectedReview);

        // When
        Integer resultReview = reviewService.getReviewByContentId(contentId);

        // Then
        assertEquals(expectedReview, resultReview);
    }
}
