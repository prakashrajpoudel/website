package org.government.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.government.api.Residence;
import org.government.dto.ResidenceDTO;
import org.government.manager.ResidenceManager;
import org.government.manager.TransformerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/residence")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResidenceResource {
	private @Autowired ResidenceManager residenceManager;
	private @Autowired TransformerManager transformerManager;

	@GET
	public Response getAll() {
		List<Residence> listOfResidence = residenceManager.getAll();
		List<ResidenceDTO> listOfResidenceDTO = transformerManager.transform(listOfResidence);
		return Response.status(Response.Status.OK).entity(listOfResidenceDTO).build();
	}

	@POST
	public Response save(ResidenceDTO residencedto) {
		Residence residence = transformerManager.transform(residencedto);
		residence = residenceManager.save(residence);
		residencedto = transformerManager.transform(residence);
		return Response.status(Response.Status.CREATED).entity(residencedto).build();
	}

	@PUT
	public Response update(ResidenceDTO residencedto) {
		Residence residence = transformerManager.transform(residencedto);
		residence = residenceManager.save(residence);
		residencedto = transformerManager.transform(residence);
		return Response.status(Response.Status.CREATED).entity(residencedto).build();
	}

	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") String uuid) {
		Residence residence = residenceManager.get(uuid);
		ResidenceDTO residenceDTO = transformerManager.transform(residence);
		return Response.status(Response.Status.CREATED).entity(residenceDTO).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") String uuid) {
		residenceManager.delete(uuid);
		return Response.noContent().build();
	}

	@PUT
	@Path("/paid/{id}")
	public Response paid(@PathParam("id") String uuid) {
		Residence residence = residenceManager.balancePaid(uuid, "paid");
		ResidenceDTO residenceDTO = transformerManager.transform(residence);
		return Response.status(Response.Status.CREATED).entity(residenceDTO).build();
	}

	@GET
	@Path("/paid")
	public Response getAllPaid() {
		List<Residence> listOfResidence = residenceManager.getAllBalancePaid();
		List<ResidenceDTO> listOfResidenceDTO = transformerManager.transform(listOfResidence);
		return Response.status(Response.Status.OK).entity(listOfResidenceDTO).build();
	}
}
