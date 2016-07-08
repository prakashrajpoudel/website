package org.government.api;

import java.security.Principal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class User implements Principal {
	private String username;
	private String firstName;
	private String lastName;

	public String getName() {
		return firstName;
	}
}
