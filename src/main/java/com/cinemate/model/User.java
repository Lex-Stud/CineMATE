package com.cinemate.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @Email @NotBlank
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private boolean isAdmin = false;
    private String profileImageUrl;
    private List<String> personalList = new ArrayList<>();
}
