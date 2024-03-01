package com.online.test_trail.controller;


import com.online.test_trail.dto.ContentDto;
import com.online.test_trail.dto.response.ContentResponse;
import com.online.test_trail.entity.Content;
import com.online.test_trail.helper.ApiResponse;
import com.online.test_trail.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/content")
@RequiredArgsConstructor
public class ContentController {
    private final ContentService contentService;
    private final ApiResponse apiResponse;


    @GetMapping
    public ResponseEntity<Map<String, Object>> get() {
        return apiResponse.successResponse("Data fetch successfully", true, null, contentService.findAll());
    }

    @GetMapping("/getAll")
    public List<Content> getAllData() {
        return contentService.getAll();
    }

    @GetMapping("/byCategory/{category}")
    public List<Content> searchByCategory(@PathVariable("category") String category) {
        return this.contentService.searchByCategory(category);
    }

    @GetMapping("/byTitle/{title}")
    public List<ContentResponse> searchByTitle(@PathVariable("title") String title) {
        return this.contentService.searchByTitle(title);
    }


    @PostMapping("/save")
    public String createData(@RequestBody ContentDto contentDto) {
        contentService.save(contentDto);
        return "created data";
    }

    @GetMapping("/{id}")
    public Optional<Content> findById(@PathVariable("id") Long id) {
        return contentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        contentService.deleteById(id);
        return "Data deleted successfully";
    }

}
