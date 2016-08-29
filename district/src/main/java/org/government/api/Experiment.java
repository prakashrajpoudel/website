package org.government.api;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Experiment extends Entity {
	private String id;

	@Length(max = 3)
	private String content;

	public Experiment() {
		// Jackson deserialization
	}

	public Experiment(String id, String content) {
		this.id = id;
		this.content = content;
	}

	@JsonProperty
	public String getId() {
		return id;
	}

	@JsonProperty
	public String getContent() {
		return content;
	}

}
