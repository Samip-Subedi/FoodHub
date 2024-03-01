package com.online.test_trail.service;

import com.online.test_trail.dto.ContentDto;
import com.online.test_trail.dto.response.ContentResponse;
import com.online.test_trail.entity.Content;

import java.util.List;
import java.util.Optional;

public interface ContentService {

    List<Content> getAll();

    List<ContentResponse> findAll();

    List<Content> searchByCategory(String category);


        Optional<Content> findById(Long id);

    List<ContentResponse> searchByTitle(String title);

    void deleteById(Long id);

    void save(ContentDto contentDto);

}
