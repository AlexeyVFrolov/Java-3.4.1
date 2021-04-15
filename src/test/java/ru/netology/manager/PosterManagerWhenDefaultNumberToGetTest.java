package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerWhenDefaultNumberToGetTest {

    PosterManager posterManager = new PosterManager();
    Poster firstPoster = new Poster(1, "Бладшот", "", "боевик");
    Poster secondPoster = new Poster(2, "Вперед", "", "мультфильм");
    Poster thirdPoster = new Poster(3, "Отель Белград", "", "комедия");
    Poster forthPoster = new Poster(4, "Джентльмены", "", "боевик");
    Poster fifthPoster = new Poster(5, "Человек-невидимка", "", "ужасы");
    Poster sixthPoster = new Poster(6, "Тролли.Мировой тур", "", "мультфильм");
    Poster seventhPoster = new Poster(7, "Номер один", "", "комедия");

    @BeforeEach
    public void setUp() {

        posterManager.addPoster(firstPoster);
        posterManager.addPoster(secondPoster);
        posterManager.addPoster(thirdPoster);
        posterManager.addPoster(forthPoster);
        posterManager.addPoster(fifthPoster);
        posterManager.addPoster(sixthPoster);
        posterManager.addPoster(seventhPoster);

    }

    @Test
    public void shouldGetDefaultNumberOfPosters() {

        Poster eighthPoster = new Poster(8, "Номер два", "", "комедия");
        Poster ninthPoster = new Poster(9, "Номер три", "", "комедия");
        Poster tenthPoster = new Poster(10, "Номер четыре", "", "комедия");
        Poster eleventhPoster = new Poster(11, "Номер пять", "", "комедия");

        posterManager.addPoster(eighthPoster);
        posterManager.addPoster(ninthPoster);
        posterManager.addPoster(tenthPoster);
        posterManager.addPoster(eleventhPoster);

        Poster[] expected = new Poster[]{eleventhPoster, tenthPoster, ninthPoster,
                eighthPoster, seventhPoster, sixthPoster,fifthPoster, forthPoster,
                thirdPoster, secondPoster};

        assertArrayEquals(expected, posterManager.getLastRequiredNumberOfPosters());
    }

    @Test
    public void shouldGetWhenLessThanDefaultNumberOfPosters() {

        Poster[] expected = new Poster[]{seventhPoster, sixthPoster,fifthPoster, forthPoster,
                thirdPoster, secondPoster, firstPoster};

        assertArrayEquals(expected, posterManager.getLastRequiredNumberOfPosters());
    }

}
