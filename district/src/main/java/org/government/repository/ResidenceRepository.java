package org.government.repository;

import java.util.UUID;

import org.government.api.Residence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidenceRepository extends JpaRepository<Residence, UUID> {

}
