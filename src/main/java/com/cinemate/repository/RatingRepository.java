package com.cinemate.repository;

import com.cinemate.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findByUserId(String userId);
    List<Rating> findByFilmId(String filmId);
}