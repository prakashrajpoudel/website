package org.government.core;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UUIDConverter implements AttributeConverter<UUID, String> {

	@Override
	public String convertToDatabaseColumn(UUID attribute) {
		if (Objects.isNull(attribute)) {
			attribute = UUID.randomUUID();
		}
		return attribute.toString();
	}

	@Override
	public UUID convertToEntityAttribute(String dbData) {
		return Objects.isNull(dbData) ? null : UUID.fromString(dbData);
	}

}
