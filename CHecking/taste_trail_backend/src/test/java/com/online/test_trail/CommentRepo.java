package com.online.test_trail;
import com.online.test_trail.entity.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CommentRepoTest {

    @Mock
    private CommentRepo commentRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindCommentByContent_Id() {
        // Given
        Long contentId = 1L;
        List<Comment> comments = new ArrayList<>();
        // Add some sample comments to the list

        when(commentRepo.findCommentByContent_Id(contentId)).thenReturn(comments);

        // When
        List<Comment> resultComments = commentRepo.findCommentByContent_Id(contentId);

        // Then
        assertEquals(comments, resultComments);
    }
}
