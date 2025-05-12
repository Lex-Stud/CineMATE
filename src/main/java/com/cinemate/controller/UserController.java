package com.cinemate.controller;

import com.cinemate.model.Film;
import com.cinemate.model.User;
import com.cinemate.service.FilmService;
import com.cinemate.service.RecommendationService;
import com.cinemate.service.UserService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired private UserService userService;
    @Autowired private FilmService filmService;
    @Autowired private RecommendationService recService;

    @PostMapping("/{userId}/list")
    public User addToList(@PathVariable String userId, @RequestBody FilmIdRequest req) {
        return userService.addToPersonalList(userId, req.getFilmId());
    }

    @GetMapping("/{userId}/list")
    public List<Film> getPersonalList(@PathVariable String userId) {
        User user = userService.getById(userId).orElseThrow();
        return filmService.findAllByIds(user.getPersonalList());
    }

    @GetMapping("/{userId}/recommendations")
    public List<Film> getRecommendations(@PathVariable String userId) {
        return recService.recommendForUser(userId);
    }

    @Data
    @NoArgsConstructor
    public static class FilmIdRequest {
        private String filmId;
    }
}
