package org.government.manager;

import java.util.List;
import java.util.Objects;

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
}
