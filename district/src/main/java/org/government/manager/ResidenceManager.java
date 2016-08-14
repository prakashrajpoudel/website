package org.government.manager;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

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

	public Residence update(Residence residence) {
		// TODO copy only non-null properties
		return residenceRepository.save(residence);
	}

	public void delete(String uuid) {
		residenceRepository.delete(uuid);
	}

	public List<Residence> getAll() {
		return residenceRepository.findAll();
	}

	public List<Residence> getAllBalancePaid() {
		return residenceRepository.findByBalancePaidIsNotNull();
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
		residence.setBalancePaid(balancePaid);
		residence = residenceRepository.save(residence);
		return residence;
	}
}
