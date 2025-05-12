package com.cinemate.service;

import com.cinemate.model.Film;
import com.cinemate.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepo;

    public List<Film> searchByTitle(String title) {
        return filmRepo.findByTitleContainingIgnoreCase(title);
    }

    public Optional<Film> getById(String id) {
        return filmRepo.findById(id);
    }

    public List<Film> findAllByIds(List<String> ids) {
        return filmRepo.findAllById(ids);
    }

    public Film save(Film film) {
        return filmRepo.save(film);
    }

    public void deleteById(String id) {
        filmRepo.deleteById(id);
    }
}