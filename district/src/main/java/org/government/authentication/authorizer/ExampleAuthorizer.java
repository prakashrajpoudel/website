package org.government.authentication.authorizer;

import org.government.api.User;

import io.dropwizard.auth.Authorizer;

public class ExampleAuthorizer implements Authorizer<User> {

	public boolean authorize(User user, String role) {
		// TODO https://github.com/prakashrajpoudel/website/issues/7
		return user.getName().equals("test") && role.equals("ADMIN");
	}

}
