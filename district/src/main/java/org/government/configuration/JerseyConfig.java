package org.government.configuration;

import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {
	private final String BASE_PACKAGE = "org.government.resource";

	public JerseyConfig() {
		// register(LoginResource.class);
		// register(ExperimentResource.class);
		packages(BASE_PACKAGE);
	}

}
