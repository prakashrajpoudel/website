package org.government.api;

import java.util.UUID;

import lombok.Data;

@Data
@javax.persistence.Entity
public class Residence  {

	private String name;
	private String age;
	private String gender;
	private UUID objectUUID;
}
