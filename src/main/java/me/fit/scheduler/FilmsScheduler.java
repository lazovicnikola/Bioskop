package me.fit.scheduler;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.scheduler.Scheduled;
import jakarta.inject.Inject;
import me.fit.model.rest.client.Film;
import me.fit.rest.client.FilmClient;
import me.fit.service.FilmService;

public class FilmsScheduler {

    @Inject
    @RestClient
    private FilmClient filmClient;
    
    @Inject
    private FilmService filmService;
    
    @Scheduled(every="10s")
    public void getAllFilms() {
        List<Film> films = filmClient.getAll();
        filmService.saveFilms(films);
    }
}
