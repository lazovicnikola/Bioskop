package me.fit.rest.server;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.rest.client.Film;
import me.fit.rest.client.FilmClient;

@Path("/film")
public class FilmRest {

    @Inject
    @RestClient
    private FilmClient filmClient;
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getFilms")
    public Response getAllFilms() {
        List<Film> films =  filmClient.getAll();
        return Response.ok().entity(films).build();
    }
}
