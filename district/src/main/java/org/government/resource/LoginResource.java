package org.government.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.government.api.User;

import io.dropwizard.auth.Auth;


@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

	@POST
	public Response login(@Auth User user) {
		user.setFirstName("Test");
		user.setLastName("Test");
		return Response.status(Response.Status.CREATED).entity(user).build();
	}
}
