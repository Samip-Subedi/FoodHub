package com.online.test_trail.controller;

import com.online.test_trail.dto.ReviewDto;
import com.online.test_trail.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @PostMapping
    public String save(@RequestBody ReviewDto reviewDto) {
        reviewService.save(reviewDto);
        return "Data saved";
    }

    @GetMapping("/{content_id}")
    public Integer getReviewByContentId(@PathVariable("content_id") Long content_id){
        return reviewService.getReviewByContentId(content_id);
    }
}