package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.PosterManager;

import static org.junit.jupiter.api.Assertions.*;

class PosterRepositoryWhenNotEmptyTest {
    PosterRepository repository = new PosterRepository();
    Poster firstPoster = new Poster(1, "Бладшот", "", "боевик");
    Poster secondPoster = new Poster(2, "Вперед", "", "мультфильм");
    Poster thirdPoster = new Poster(3, "Отель Белград", "", "комедия");
    Poster forthPoster = new Poster(4, "Джентльмены", "", "боевик");
    Poster fifthPoster = new Poster(5, "Человек-невидимка", "", "ужасы");
    Poster sixthPoster = new Poster(6, "Тролли.Мировой тур", "", "мультфильм");
    Poster seventhPoster = new Poster(7, "Номер один", "", "комедия");

    @BeforeEach
    public void setUp() {

        repository.save(firstPoster);
        repository.save(secondPoster);
        repository.save(thirdPoster);
        repository.save(forthPoster);
        repository.save(fifthPoster);
        repository.save(sixthPoster);
        repository.save(seventhPoster);
    }

    @Test
    public void shouldFindByIdIfExists() {
        int idToFind = 3;
        Poster expected = new Poster(3, "Отель Белград", "", "комедия");

        assertEquals(expected, repository.findById(idToFind));
    }

    @Test
    public void shouldNotFindByIdIfNotExists() {
        int idToFind = 9;
        Poster expected = null;

        assertEquals(expected, repository.findById(idToFind));
    }

    @Test
    public void shouldRemoveByIdIfExists() {
        int idToRemove = 4;
        Poster[] expected = new Poster[]{firstPoster, secondPoster, thirdPoster, fifthPoster, sixthPoster, seventhPoster};

        repository.removeById(idToRemove);
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void shouldNotRemoveByIdIfNotExists() {
        int idToRemove = 9;
        Poster[] expected = new Poster[]{firstPoster, secondPoster, thirdPoster, forthPoster, fifthPoster, sixthPoster, seventhPoster};

        repository.removeById(idToRemove);
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void shouldRemoveAll() {
        Poster[] expected = new Poster[0];

        repository.removeAll();
        assertArrayEquals(expected, repository.findAll());
    }

}