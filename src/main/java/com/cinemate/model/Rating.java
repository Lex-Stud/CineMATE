package com.cinemate.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ratings")
public class Rating {
    @Id
    private String id;

    @NotBlank
    private String userId;

    @NotBlank
    private String filmId;

    @Min(1) @Max(5)
    private int stars;
}