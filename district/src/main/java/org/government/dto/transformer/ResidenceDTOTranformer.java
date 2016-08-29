package org.government.dto.transformer;

import java.util.Objects;

import org.government.api.Residence;
import org.government.dto.ResidenceDTO;
import org.springframework.beans.BeanUtils;

public class ResidenceDTOTranformer extends ModelTransformer<Residence, ResidenceDTO> {

	@Override
	public Residence transform(ResidenceDTO model) {
		Residence residence = new Residence();
		BeanUtils.copyProperties(model, residence);
		if (Objects.nonNull(model.getId())) {
			residence.setId(model.getId().toString());
		}
		return residence;
	}

}
