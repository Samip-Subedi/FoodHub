package com.online.test_trail.service.impl;

import com.online.test_trail.dto.FavouriteDto;
import com.online.test_trail.entity.Content;
import com.online.test_trail.entity.Favourite;
import com.online.test_trail.entity.UserEntity;
import com.online.test_trail.repo.ContentRepo;
import com.online.test_trail.repo.FavouriteRepo;
import com.online.test_trail.repo.UserRepo;
import com.online.test_trail.service.FavouriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class FavouriteServiceImpl implements FavouriteService {

    private final FavouriteRepo favouriteRepo;
    private final UserRepo userRepo;
    private final ContentRepo contentRepo;

    @Override
    public void save(FavouriteDto favouriteDto) {
        Favourite favourite;

        if (favouriteDto.getId() != null) {
            favourite = favouriteRepo.findById(favouriteDto.getId()).get();
        } else {
            favourite = new Favourite();
        }

        Content content = contentRepo.findById(favouriteDto.getContentId()).get();
        UserEntity user = userRepo.findById(favouriteDto.getUserId()).get();


        favourite.setContent(content);
        favourite.setUserId(user);
        favourite.setIsLike(favouriteDto.getIsLike());

        favouriteRepo.save(favourite);
    }

    @Override
    public List<Favourite> findByUserId(Integer userId) {
        return favouriteRepo.findAllByUserId(userId);
    }
}
