package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Poster {
    private int id;
    private String movieName;
    private String movieImageUrl;
    private String genre;
}
