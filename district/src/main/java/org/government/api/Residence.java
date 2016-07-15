package org.government.api;

import java.util.UUID;

import lombok.Data;

@Data
public class Residence implements Entity {

	private String name;
	private String age;
	private String gender;
	private UUID objectUUID;

	@Override
	public UUID getObjectUUID() {
		return objectUUID;
	}

	@Override
	public void setObjectUUID(UUID objectUUID) {
		this.objectUUID = objectUUID;
	}

}
