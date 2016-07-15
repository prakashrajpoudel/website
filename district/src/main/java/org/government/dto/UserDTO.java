package org.government.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserDTO {
	private @JsonProperty String username;
	private @JsonProperty String password;
}
