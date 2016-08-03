package org.government.repository;

import org.government.api.Residence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidenceRepository extends JpaRepository<Residence, String> {
	Residence findById(String id);
}
