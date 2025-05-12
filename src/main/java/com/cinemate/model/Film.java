package com.cinemate.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "films")
public class Film {
    @Id
    private String id;
    private String title;
    private String description;
    private String genre;
    private int releaseYear;
    private String trailerUrl;
    private double averageRating;
    private int numberOfRatings;
}