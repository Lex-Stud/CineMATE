package com.cinemate.controller;

import com.cinemate.model.Rating;
import com.cinemate.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    @Autowired private RatingService ratingService;

    @PostMapping
    public Rating rate(@RequestBody Rating rating) {
        return ratingService.addRating(rating);
    }
}