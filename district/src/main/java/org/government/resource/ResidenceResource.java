package org.government.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.government.api.Residence;
import org.government.dto.ResidenceDTO;
import org.government.dto.converter.ResidenceDTOConverter;
import org.government.manager.ResidenceJSONFileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/residence")
@Produces(MediaType.APPLICATION_JSON)
public class ResidenceResource {
	private @Autowired ResidenceJSONFileManager fileManager;
	private @Autowired ResidenceDTOConverter residenceDTOConverter;

	@GET
	public Response getAll() {
		List<Residence> listOfResidence = fileManager.getAll();
		List<ResidenceDTO> listOfResidenceDTO = residenceDTOConverter.convertAll(listOfResidence);
		return Response.status(Response.Status.OK).entity(listOfResidenceDTO).build();
	}

	@POST
	public Response save(ResidenceDTO residencedto) {
		Residence residence = residenceDTOConverter.convert(residencedto);
		residence = fileManager.save(residence);
		return Response.status(Response.Status.CREATED).entity(residence).build();
	}

}
