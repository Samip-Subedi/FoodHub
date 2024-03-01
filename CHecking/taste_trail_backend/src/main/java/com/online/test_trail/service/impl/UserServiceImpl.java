package com.online.test_trail.service.impl;

import com.online.test_trail.config.PasswordEncoderUtil;
import com.online.test_trail.dto.UserDto;
import com.online.test_trail.entity.UserEntity;
import com.online.test_trail.repo.UserRepo;
import com.online.test_trail.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public List<UserEntity> findAll() {
        return userRepo.findAll();
    }


    @Override
    public Optional<UserEntity> findById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public void save(UserDto userDto) {
        UserEntity userEntity;

        if (userDto.getId() != null) {
            userEntity = userRepo.findById(userDto.getId()).get();
        } else {
            userEntity = new UserEntity();
        }


        userEntity.setEmail(userDto.getEmail());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setPassword(PasswordEncoderUtil.getInstance().encode(userDto.getPassword()));
        userEntity.setConfirmPassword(PasswordEncoderUtil.getInstance().encode(userDto.getConfirmPassword()));


        userRepo.save(userEntity);
    }
    @Override
    public void updateUser(Integer id, UserDto userDto) {
        UserEntity userEntity = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Update userEntity fields with userDto data
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setEmail(userDto.getEmail());

        // Save the updated userEntity
        userRepo.save(userEntity);
    }
}
