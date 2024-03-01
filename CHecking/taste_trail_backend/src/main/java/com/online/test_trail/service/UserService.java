package com.online.test_trail.service;

import com.online.test_trail.dto.UserDto;
import com.online.test_trail.entity.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserService {
    List<UserEntity> findAll();

    Optional<UserEntity> findById(Integer id);

    void deleteById(Integer id);

    void save(UserDto userDto);

    void updateUser(Integer id, UserDto userDto);
}