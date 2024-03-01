package com.online.test_trail;
import com.online.test_trail.entity.Favourite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FavouriteRepoTest {

    @Mock
    private FavouriteRepo favouriteRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByContent() {
        // Given
        Long contentId = 1L;
        Optional<Favourite> favourite = Optional.of(new Favourite());
        // Mocking the behaviour of the repository method
        when(favouriteRepo.findByContent(contentId)).thenReturn(favourite);

        // When
        Optional<Favourite> result = favouriteRepo.findByContent(contentId);

        // Then
        assertEquals(favourite, result);
    }

    @Test
    public void testFindAllByUserId() {
        // Given
        Integer userId = 1;
        List<Favourite> favouriteList = new ArrayList<>();
        // Add some sample favourites to the list

        when(favouriteRepo.findAllByUserId(userId)).thenReturn(favouriteList);

        // When
        List<Favourite> result = favouriteRepo.findAllByUserId(userId);

        // Then
        assertEquals(favouriteList, result);
    }
}
