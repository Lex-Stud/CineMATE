package com.cinemate.service;

import com.cinemate.model.Film;
import com.cinemate.model.Rating;
import com.cinemate.repository.FilmRepository;
import com.cinemate.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecommendationService {
    @Autowired
    private FilmRepository filmRepo;

    @Autowired
    private RatingRepository ratingRepo;

    public List<Film> recommendForUser(String userId) {
        List<Rating> userRatings = ratingRepo.findByUserId(userId);
        Set<String> ratedFilmIds = userRatings.stream().map(Rating::getFilmId).collect(Collectors.toSet());
        return filmRepo.findAll().stream()
                .filter(f -> !ratedFilmIds.contains(f.getId()))
                .sorted((f1, f2) -> Double.compare(f2.getAverageRating(), f1.getAverageRating()))
                .limit(10)
                .collect(Collectors.toList());
    }
}