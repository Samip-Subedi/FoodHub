package com.online.test_trail.service;

import com.online.test_trail.dto.ReviewDto;

public interface ReviewService {
    void save(ReviewDto reviewDto);

    Integer getReviewByContentId(Long content_id);

}
