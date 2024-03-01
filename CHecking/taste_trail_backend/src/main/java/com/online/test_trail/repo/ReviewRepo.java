package com.online.test_trail.repo;

import com.online.test_trail.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {


    @Query(value = "select avg(r.rate) from review r where content_id=?1",nativeQuery = true)
    Integer getReviewByContentId(Long content_id);
}
