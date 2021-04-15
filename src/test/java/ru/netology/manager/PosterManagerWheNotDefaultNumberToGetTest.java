package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.*;

public class PosterManagerWheNotDefaultNumberToGetTest {

    PosterManager posterManager = new PosterManager(5);
    Poster firstPoster = new Poster(1, "Бладшот", "", "боевик");
    Poster secondPoster = new Poster(2, "Вперед", "", "мультфильм");
    Poster thirdPoster = new Poster(3, "Отель Белград", "", "комедия");

    @BeforeEach
    public void setUp() {

        posterManager.addPoster(firstPoster);
        posterManager.addPoster(secondPoster);
        posterManager.addPoster(thirdPoster);

    }

    @Test
    public void shouldGetAssinedNumberOfPosters() {

        Poster forthPoster = new Poster(4, "Джентльмены", "", "боевик");
        Poster fifthPoster = new Poster(5, "Человек-невидимка", "", "ужасы");
        Poster sixthPoster = new Poster(6, "Тролли.Мировой тур", "", "мультфильм");

        posterManager.addPoster(forthPoster);
        posterManager.addPoster(fifthPoster);
        posterManager.addPoster(sixthPoster);

        Poster[] expected = new Poster[]{sixthPoster,fifthPoster, forthPoster,
                thirdPoster, secondPoster};

        assertArrayEquals(expected, posterManager.getLastRequiredNumberOfPosters());
    }

    @Test
    public void shouldGetWhenLessThanDefaultNumberOfPosters() {

        Poster[] expected = new Poster[]{thirdPoster, secondPoster, firstPoster};

        assertArrayEquals(expected, posterManager.getLastRequiredNumberOfPosters());
    }
}
