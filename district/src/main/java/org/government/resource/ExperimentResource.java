package org.government.resource;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.government.api.Experiment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Path("/experiment")
@Produces(MediaType.APPLICATION_JSON)
public class ExperimentResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExperimentResource.class);

	@GET
	public Response sayHello() {
		LOGGER.info("Request");
		final String value = "Test";
		Experiment experiment = new Experiment(value, value);
		return Response.status(Response.Status.CREATED).entity(experiment).build();
	}

	@POST
	public Experiment postHello(Experiment experiment) {
		// return new Experiment(counter.incrementAndGet(),
		// experiment.getContent());
		return null;
	}

}
