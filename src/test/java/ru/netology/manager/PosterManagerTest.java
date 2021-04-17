package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Poster;
import ru.netology.domain.PosterRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PosterManagerTest {
    @Mock
    private PosterRepository repository;
    @InjectMocks
    private PosterManager posterManager;
    Poster firstPoster = new Poster(1, "Бладшот", "", "боевик");
    Poster secondPoster = new Poster(2, "Вперед", "", "мультфильм");
    Poster thirdPoster = new Poster(3, "Отель Белград", "", "комедия");
    Poster forthPoster = new Poster(4, "Джентльмены", "", "боевик");
    Poster fifthPoster = new Poster(5, "Человек-невидимка", "", "ужасы");

    @Test
    public void shouldAddPoster(){
        Poster[] returned = new Poster[] {firstPoster};
        doReturn(returned).when(repository).findAll();

        Poster[] expected = new Poster[] {firstPoster};
        posterManager.addPoster(firstPoster);
        assertArrayEquals(expected, posterManager.getAllPosters());
    }

    @Test
    public void shouldGetAllPosters(){
        Poster[] returned = new Poster[] {firstPoster, secondPoster, thirdPoster, forthPoster, fifthPoster};
        doReturn(returned).when(repository).findAll();

        posterManager.addPoster(firstPoster);
        posterManager.addPoster(secondPoster);
        posterManager.addPoster(thirdPoster);
        posterManager.addPoster(forthPoster);
        posterManager.addPoster(fifthPoster);

        Poster[] expected = new Poster[] {fifthPoster, forthPoster, thirdPoster, secondPoster, firstPoster};
        assertArrayEquals(expected, posterManager.getAllPosters());
    }

    @Test
    public void shouldRemoveByIdIfExists(){
        Poster[] returned = new Poster[] {firstPoster, secondPoster, thirdPoster, fifthPoster};
        doReturn(returned).when(repository).findAll();

        posterManager.addPoster(firstPoster);
        posterManager.addPoster(secondPoster);
        posterManager.addPoster(thirdPoster);
        posterManager.addPoster(forthPoster);
        posterManager.addPoster(fifthPoster);

        int idToRemove = 4;
        Poster[] expected = new Poster[] {fifthPoster, thirdPoster, secondPoster, firstPoster};

        posterManager.removeById(idToRemove);
        assertArrayEquals(expected, posterManager.getAllPosters());
    }

    @Test
    public void shouldNotRemoveByIdIfNotExists(){
        Poster[] returned = new Poster[] {firstPoster, secondPoster, thirdPoster, forthPoster, fifthPoster};
        doReturn(returned).when(repository).findAll();

        posterManager.addPoster(firstPoster);
        posterManager.addPoster(secondPoster);
        posterManager.addPoster(thirdPoster);
        posterManager.addPoster(forthPoster);
        posterManager.addPoster(fifthPoster);

        int idToRemove = 9;
        Poster[] expected = new Poster[] {fifthPoster, forthPoster, thirdPoster, secondPoster, firstPoster};

        posterManager.removeById(idToRemove);
        assertArrayEquals(expected, posterManager.getAllPosters());
    }
}