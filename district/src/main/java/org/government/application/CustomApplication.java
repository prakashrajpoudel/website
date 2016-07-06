package org.government.application;

import org.government.configuration.ApplicationConfiguration;
import org.government.resource.ExperimentResource;
import org.government.resource.LoginResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CustomApplication extends Application<ApplicationConfiguration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomApplication.class);

	public static void main(String[] args) throws Exception {
		new CustomApplication().run(args);
	}

	@Override
	public void run(ApplicationConfiguration configuration, Environment environment) throws Exception {
		ExperimentResource resource = new ExperimentResource(configuration.getTemplate(),
				configuration.getDefaultName());
		LoginResource loginResource = new LoginResource();
		environment.jersey().register(resource);
		environment.jersey().register(loginResource);
	}

	@Override
	public String getName() {
		return "hello-world";
	}

	@Override
	public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
		// nothing to do yet
		bootstrap.addBundle(new AssetsBundle("/assets/", "/", "index.html"));
		bootstrap.addBundle(new AssetsBundle("/assets/css", "/css", null, "css"));
		bootstrap.addBundle(new AssetsBundle("/assets/js", "/js", null, "js"));

	}

}
