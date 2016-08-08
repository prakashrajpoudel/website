package org.government.repository;

import java.util.List;

import org.government.api.Residence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidenceRepository extends JpaRepository<Residence, String> {
	Residence findById(String id);

	List<Residence> findByBalancePaidIsNotNull();
}
