package ru.netology.domain;

public class PosterRepository {
    private Poster[] posters = new Poster[0];

    public void save(Poster newPoster) {
        Poster[] tmp = new Poster[posters.length + 1];

        System.arraycopy(posters, 0, tmp, 0, posters.length);
        tmp[tmp.length - 1] = newPoster;
        posters = tmp;
    }

    public Poster[] findAll() {
        return posters;
    }

    public Poster findById(int id) {

        for (Poster poster : posters) {
            if (poster.getId() == id) {
                return poster;
            }
        }
        return null;
    }

    public void removeById(int id) {
        boolean isPosterToRemove = false;

        for (Poster poster : posters) {
            if (poster.getId() == id) isPosterToRemove = true;
        }
        if (isPosterToRemove) {
            Poster[] tmp = new Poster[posters.length - 1];
            int index = 0;
            for (Poster poster : posters) {
                if (poster.getId() != id) {
                    tmp[index] = poster;
                    index++;
                }
            }
            // меняем наши элементы
            posters = tmp;
        }
    }

    public void removeAll(){
        posters = new Poster[0];
    }
}