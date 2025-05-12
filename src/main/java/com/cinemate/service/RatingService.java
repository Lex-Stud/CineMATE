package com.cinemate.service;

import com.cinemate.model.Rating;
import com.cinemate.model.Film;
import com.cinemate.repository.RatingRepository;
import com.cinemate.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepo;

    @Autowired
    private FilmRepository filmRepo;

    public Rating addRating(Rating rating) {
        Rating saved = ratingRepo.save(rating);
        updateFilmAverage(rating.getFilmId());
        return saved;
    }

    private void updateFilmAverage(String filmId) {
        List<Rating> ratings = ratingRepo.findByFilmId(filmId);
        double avg = ratings.stream().mapToInt(Rating::getStars).average().orElse(0);
        Film film = filmRepo.findById(filmId).orElseThrow();
        film.setAverageRating(avg);
        film.setNumberOfRatings(ratings.size());
        filmRepo.save(film);
    }
}