package org.government.manager;

import java.util.List;

import org.government.api.Residence;
import org.government.repository.ResidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResidenceJSONFileManager {

	private @Autowired ResidenceRepository residenceRepository;

	public Residence save(Residence residence) {
		return residenceRepository.save(residence);
	}

	public List<Residence> getAll() {
		return residenceRepository.findAll();
	}
}
