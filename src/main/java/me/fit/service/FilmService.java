package me.fit.service;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.rest.client.Film;

@Dependent
public class FilmService {
    
    @Inject
    private EntityManager em;

    @Transactional
    public void saveFilms(List<Film> films) {
        
        List<Film> savedFilms = getAllFilms();
        
        films.removeAll(savedFilms);
        
        for (Film film : films) {
            em.merge(film);
        }
    }
    
    @Transactional
    public List<Film> getAllFilms(){
        return em.createNamedQuery(Film.GET_ALL, Film.class).getResultList();
    }
}
