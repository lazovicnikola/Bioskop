package me.fit.rest.server;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.exception.KorisnikException;
import me.fit.model.Rezervacija;
import me.fit.service.RezervacijaService;

@Path("/rezervacija")
public class RezervacijaRest {

    @Inject
    private RezervacijaService rezervacijaService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createRezervacija")
    public Response createRezervacija(Rezervacija rezervacija) {
        Rezervacija r = null;
		try {
			r = rezervacijaService.createRezervacija(rezervacija);
		} catch (KorisnikException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return Response.ok().entity(r).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllRezervacije")
    public Response getAllRezervacije() {
        List<Rezervacija> rezervacije = rezervacijaService.getAllRezervacije();
        return Response.ok().entity(rezervacije).build();
    }
}