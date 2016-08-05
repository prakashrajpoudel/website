package org.government.api;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@javax.persistence.Entity
public class MoneyPaid extends Entity {
	private boolean isPaid;
	private Date paidDate;
}
