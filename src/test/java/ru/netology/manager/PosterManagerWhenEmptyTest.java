package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerWhenEmptyTest {

    @Test
    public void shouldAddPoster() {

        PosterManager posterManager = new PosterManager();
        Poster newPoster = new Poster(1, "Бладшот", "", "боевик");

        posterManager.addPoster(newPoster);
        Poster[] expected = new Poster[]{newPoster};
        assertArrayEquals(expected, posterManager.getPosters());
    }

}
