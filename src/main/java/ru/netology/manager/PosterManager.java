package ru.netology.manager;

import ru.netology.domain.Poster;
import ru.netology.domain.PosterRepository;

public class PosterManager {
    private PosterRepository repository;

    public PosterManager(PosterRepository repository){
        this.repository = repository;
    }

    public void addPoster(Poster newPoster) {
        repository.save(newPoster);
    }

    public Poster[] getAllPosters() {
        Poster[] posters = repository.findAll();
        Poster[] result = new Poster[posters.length];
        for (int i = 0; i < result.length; i++) {
            int index = posters.length - i - 1;
            result[i] = posters[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

}
