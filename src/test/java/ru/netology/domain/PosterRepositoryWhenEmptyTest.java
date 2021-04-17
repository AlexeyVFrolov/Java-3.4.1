package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosterRepositoryWhenEmptyTest {

    @Test
    public void shouldAddPoster() {
        PosterRepository repository = new PosterRepository();
        Poster newPoster = new Poster(1, "Бладшот", "", "боевик");

        repository.save(newPoster);
        Poster[] expected = new Poster[]{newPoster};
        assertArrayEquals(expected, repository.findAll());
    }
}