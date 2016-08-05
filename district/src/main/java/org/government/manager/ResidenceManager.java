package org.government.manager;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.government.api.BalancePaid;
import org.government.api.Residence;
import org.government.repository.ResidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResidenceManager {

	private @Autowired ResidenceRepository residenceRepository;

	public Residence save(Residence residence) {
		return residenceRepository.save(residence);
	}

	public List<Residence> getAll() {
		return residenceRepository.findAll();
	}

	public Residence get(String uuid) {
		Residence residence = residenceRepository.findById(uuid);
		if (Objects.isNull(residence)) {
			throw new RuntimeException("Object can not be null");
		}
		return residence;
	}

	public Residence balancePaid(String uuid, String paid) {
		Residence residence = residenceRepository.findById(uuid);
		BalancePaid balancePaid = new BalancePaid();
		// Change in-line string
		balancePaid.setPaid(paid);
		balancePaid.setPaidDate(Calendar.getInstance().getTime());
		residence.setMoneyPaid(balancePaid);
		residence = residenceRepository.save(residence);
		return residence;
	}
}
