package com.online.test_trail.repo;

import com.online.test_trail.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    @Query(value = "select * from users where username=?1", nativeQuery = true)
    Optional<UserEntity> getUserByUsername(String username);


//    @Query(value = "select * from users where email=?1", nativeQuery = true)
//    Optional<UserEntity> getUserByUsername(String email);
}
