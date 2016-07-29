package org.government.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.government.api.Residence;
import org.government.dto.ResidenceDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ResidenceDTOConverter {

	public ResidenceDTO convert(Residence residence) {
		ResidenceDTO residenceDTO = new ResidenceDTO();
		BeanUtils.copyProperties(residence, residenceDTO);
		return residenceDTO;
	}

	public List<ResidenceDTO> convertAll(List<Residence> residenceList) {
		List<ResidenceDTO> listOfResidence = new ArrayList<>();
		residenceList.stream().forEach(residence -> {
			listOfResidence.add(convert(residence));
		});
		return listOfResidence;
	}

	public Residence convert(ResidenceDTO residenceDTO) {
		Residence residence = new Residence();
		BeanUtils.copyProperties(residenceDTO, residence);
		return residence;
	}
}
