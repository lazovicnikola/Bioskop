package me.fit.rest.server;

import java.util.List;

import org.jboss.resteasy.reactive.RestResponse.Status;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.exception.KorisnikException;
import me.fit.model.Korisnik;
import me.fit.service.KorisnikService;

@Path("/korisnik")
public class KorisnikRest {

    @Inject
    private KorisnikService korisnikService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createKorisnik")
    public Response createKorisnik(Korisnik korisnik) {
        Korisnik k = null;
        try {
            k = korisnikService.createKorisnik(korisnik);
        } catch (KorisnikException e) {
            return Response.status(Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok().entity(k).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cao")
    public String hello() {
        return "Čao";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllKorisnici")
    public Response getAllKorisnici() {
        List<Korisnik> korisnici = korisnikService.getAllKorisnici();
        return Response.ok().entity(korisnici).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getKorisniciByIme")
    public Response getKorisniciByIme(@QueryParam(value = "ime") String ime) {
        List<Korisnik> korisnici = korisnikService.getKorisniciByIme(ime);
        return Response.ok().entity(korisnici).build();
    }
}
