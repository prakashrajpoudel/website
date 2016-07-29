package org.government.api;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.government.core.UUIDGenerator;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_gen")
	@GenericGenerator(name = "id_gen", strategy = UUIDGenerator.CLASSNAME)
	private UUID objectUUID;
}
