package org.government.api;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@javax.persistence.Entity
public class Residence extends Entity {
	private String name;
	private String age;
	private String gender;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "residence_id")
	private MoneyPaid moneyPaid;
}
