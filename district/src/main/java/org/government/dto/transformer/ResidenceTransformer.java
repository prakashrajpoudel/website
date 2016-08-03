package org.government.dto.transformer;

import java.util.UUID;

import org.government.api.Residence;
import org.government.dto.ResidenceDTO;
import org.springframework.beans.BeanUtils;

public class ResidenceTransformer extends ModelTransformer<ResidenceDTO, Residence> {

	@Override
	public ResidenceDTO transform(Residence model) {
		ResidenceDTO residenceDto = new ResidenceDTO();
		BeanUtils.copyProperties(model, residenceDto);
		residenceDto.setId(UUID.fromString(model.getId()));
		return residenceDto;
	}

}
