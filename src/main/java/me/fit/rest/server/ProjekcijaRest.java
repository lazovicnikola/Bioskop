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
import me.fit.model.Projekcija;
import me.fit.service.ProjekcijaService;

@Path("/projekcija")
public class ProjekcijaRest {

    @Inject
    private ProjekcijaService projekcijaService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createProjekcija")
    public Response createProjekcija(Projekcija projekcija) {
        Projekcija p = null;
		try {
			p = projekcijaService.createProjekcija(projekcija);
		} catch (KorisnikException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return Response.ok().entity(p).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllProjekcije")
    public Response getAllProjekcije() {
        List<Projekcija> projekcije = projekcijaService.getAllProjekcije();
        return Response.ok().entity(projekcije).build();
    }
}
