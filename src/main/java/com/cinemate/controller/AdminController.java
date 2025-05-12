package com.cinemate.controller;

import com.cinemate.model.Film;
import com.cinemate.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/films")
public class AdminController {
    @Autowired private FilmService filmService;

    @PostMapping
    public Film add(@RequestBody Film film) {
        return filmService.save(film);
    }

    @PutMapping("/{id}")
    public Film update(@PathVariable String id, @RequestBody Film film) {
        film.setId(id);
        return filmService.save(film);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        filmService.deleteById(id);
    }
}
