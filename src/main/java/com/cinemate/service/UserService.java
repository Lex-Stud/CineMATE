package com.cinemate.service;

import com.cinemate.model.User;
import com.cinemate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public Optional<User> getById(String id) {
        return userRepo.findById(id);
    }

    public User update(User user) {
        return userRepo.save(user);
    }

    public User addToPersonalList(String userId, String filmId) {
        User user = getById(userId).orElseThrow();
        if (!user.getPersonalList().contains(filmId)) {
            user.getPersonalList().add(filmId);
            userRepo.save(user);
        }
        return user;
    }
}