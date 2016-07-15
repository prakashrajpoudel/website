package org.government.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.government.dto.UserDTO;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

	//https://github.com/prakashrajpoudel/website/issues/10
	@POST
	public Response login(UserDTO userdto, @Context HttpServletRequest request) {
		return Response.status(Response.Status.CREATED).entity(userdto).build();
	}
}
