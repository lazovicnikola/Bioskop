package me.fit.rest.server;



import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.rest.client.IpClient;
import me.fit.rest.client.IpClientClient;


@Path("/client")
public class IpClientRest {
	
	@Inject
	@RestClient
	private IpClientClient ipClinet;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getIpClient")
	public Response getIpClient() {
		IpClient client =  ipClinet.get();
		return Response.ok().entity(client).build();
	}
}
