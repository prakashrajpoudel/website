package org.government.resource;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.government.api.Experiment;
import org.government.utils.JSONFileUtils;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import io.dropwizard.auth.Auth;

@Path("/experiment")
@Produces(MediaType.APPLICATION_JSON)
public class ExperimentResource {
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;

	public ExperimentResource(String template, String defaultName) {
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}

	@GET
	@Timed
	public Experiment sayHello(@Auth @QueryParam("name") Optional<String> name) {
		JSONFileUtils.INSTANCE.loadAll();
		final String value = String.format(template, name.or(defaultName));
		return new Experiment(counter.incrementAndGet(), value);
	}

	@POST
	@Timed
	public Experiment postHello(Experiment experiment) {
		JSONFileUtils.INSTANCE.save(experiment);
		return new Experiment(counter.incrementAndGet(), experiment.getContent());
	}

}
