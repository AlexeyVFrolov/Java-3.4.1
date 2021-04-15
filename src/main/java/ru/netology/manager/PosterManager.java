package ru.netology.manager;

import ru.netology.domain.Poster;

public class PosterManager {
    private Poster[] posters = new Poster[0];
    private int postersQuantityToGet;

    public PosterManager(){
        postersQuantityToGet = 10;
    }

    public PosterManager(int QuantityToGet){
        this.postersQuantityToGet = QuantityToGet;
    }

    public Poster[] getPosters() {
        return posters;
    }

    public void addPoster(Poster newPoster) {
        // создаём новый массив размером на единицу больше
        Poster[] tmp = new Poster[posters.length + 1];

        System.arraycopy(posters, 0, tmp, 0, posters.length);
        // кладём последним наш элемент
        tmp[tmp.length - 1] = newPoster;
        posters = tmp;
    }

    public Poster[] getLastRequiredNumberOfPosters() {
        Poster[] result = new Poster[(postersQuantityToGet < posters.length) ? postersQuantityToGet : posters.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = posters.length - i - 1;
            result[i] = posters[index];
        }
        return result;
    }
}
