package com.cinemate.repository;

import com.cinemate.model.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface FilmRepository extends MongoRepository<Film, String> {
    List<Film> findByTitleContainingIgnoreCase(String title);
}