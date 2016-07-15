package org.government.api;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Experiment implements Entity {
	private long id;
	private UUID objectUUID;

	@Length(max = 3)
	private String content;

	public Experiment() {
		// Jackson deserialization
	}

	public Experiment(long id, String content) {
		this.id = id;
		this.content = content;
	}

	@JsonProperty
	public long getId() {
		return id;
	}

	@JsonProperty
	public String getContent() {
		return content;
	}

	@Override
	public UUID getObjectUUID() {
		return objectUUID;
	}

	public void setObjectUUID(UUID objectUUID) {
		this.objectUUID = objectUUID;
	}
}
