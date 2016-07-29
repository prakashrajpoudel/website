package org.government.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@javax.persistence.Entity
public class Residence extends Entity {
	private String name;
	private String age;
	private String gender;
}
