package org.government.manager;

import java.util.List;

import org.government.api.Residence;
import org.government.utils.JSONFileRepository;
import org.government.utils.ResidenceJSONFileRepository;

public class ResidenceJSONFileManager {
	JSONFileRepository residenceRepository = new ResidenceJSONFileRepository();

	public Residence save(Residence residence) {
		// return residenceRepository.save(residence);
		return null;
	}

	public List<Residence> getAll() {
		return residenceRepository.loadAll();
	}
}
