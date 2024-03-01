package com.online.test_trail.repo;

import com.online.test_trail.entity.Content;
import com.online.test_trail.entity.Favourite;
import com.online.test_trail.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FavouriteRepo extends JpaRepository<Favourite, Long> {

    @Query(value = "select * from favourite where content_id=?1",nativeQuery = true)
    Optional<Favourite> findByContent(Long content_id);


    @Query(value = "select * from favourite where user_id=?1",nativeQuery = true)
    List<Favourite> findAllByUserId(Integer userId);
}
