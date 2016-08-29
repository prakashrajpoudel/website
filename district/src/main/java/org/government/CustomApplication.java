package org.government;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.government.configuration.JerseyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class CustomApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomApplication.class);

	public static void main(String[] args) {
		new SpringApplicationBuilder(CustomApplication.class).run(args);
	}

	@Bean
	public ServletRegistrationBean jerseyServlet() {
		LOGGER.debug("Initializing {}", JerseyConfig.class.getName());
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/api/*");
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
		return registration;
	}

}
