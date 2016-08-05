package org.government.dto.transformer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.UUID;

import org.government.api.MoneyPaid;
import org.government.api.Residence;
import org.government.dto.ResidenceDTO;
import org.springframework.beans.BeanUtils;

public class ResidenceTransformer extends ModelTransformer<ResidenceDTO, Residence> {

	@Override
	public ResidenceDTO transform(Residence model) {
		ResidenceDTO residenceDto = new ResidenceDTO();
		BeanUtils.copyProperties(model, residenceDto);
		residenceDto.setId(UUID.fromString(model.getId()));
		MoneyPaid paid = model.getMoneyPaid();
		if (Objects.nonNull(paid)) {
			residenceDto.setIsPaid(String.valueOf(paid.isPaid()));
			// Removed simpleDateFormat from here
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			residenceDto.setPaidDate(df.format(paid.getPaidDate()));
		}
		return residenceDto;
	}

}
