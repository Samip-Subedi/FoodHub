package com.online.test_trail.controller;

import com.online.test_trail.dto.FavouriteDto;
import com.online.test_trail.entity.Favourite;
import com.online.test_trail.service.FavouriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favourite")
@RequiredArgsConstructor
public class FavouriteController {

    private final FavouriteService favouriteService;


    @PostMapping
    public String save(@RequestBody FavouriteDto favouriteDto) {
        favouriteService.save(favouriteDto);
        return "Data saved";
    }

    @GetMapping("/userId/{userId}")
    public List<Favourite> getAllFavByUserId(@PathVariable("userId") Integer userId){
        return favouriteService.findByUserId(userId);
    }
}



