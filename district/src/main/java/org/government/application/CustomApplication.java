package org.government.application;

import org.government.configuration.ApplicationConfiguration;
import org.government.resource.ExperimentResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CustomApplication extends Application<ApplicationConfiguration> {

	public static void main(String[] args) throws Exception {
		new CustomApplication().run(args);
	}

	@Override
	public void run(ApplicationConfiguration configuration, Environment environment) throws Exception {
		final ExperimentResource resource = new ExperimentResource(configuration.getTemplate(),
				configuration.getDefaultName());
		environment.jersey().register(resource);
	}

	@Override
	public String getName() {
		return "hello-world";
	}

	@Override
	public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
		// nothing to do yet
	}

}
