package com.online.test_trail.service;

import com.online.test_trail.dto.FavouriteDto;
import com.online.test_trail.entity.Favourite;

import java.util.List;

import java.util.List;

public interface FavouriteService {
    void save(FavouriteDto favouriteDto);

    List<Favourite> findByUserId(Integer userId);
}
