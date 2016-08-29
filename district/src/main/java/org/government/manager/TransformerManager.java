package org.government.manager;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.government.api.Residence;
import org.government.dto.ResidenceDTO;
import org.government.dto.transformer.ModelTransformer;
import org.government.dto.transformer.ResidenceDTOTranformer;
import org.government.dto.transformer.ResidenceTransformer;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;

import jersey.repackaged.com.google.common.collect.Lists;

@Component
public class TransformerManager {
	@SuppressWarnings("rawtypes")
	private Map<Class<?>, ModelTransformer> instancesMap;

	public TransformerManager() {
		instancesMap = Maps.newHashMap();
		try {
			buildInstancesMap();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	protected void buildInstancesMap() throws InstantiationException, IllegalAccessException {
		instancesMap.put(ResidenceDTO.class, ResidenceDTOTranformer.class.newInstance());
		instancesMap.put(Residence.class, ResidenceTransformer.class.newInstance());
	}

	@SuppressWarnings("unchecked")
	public <T, M> T transform(M model) {
		ModelTransformer<T, M> modelTransformer = instancesMap.get(model.getClass());
		if (Objects.isNull(modelTransformer)) {
			throw new RuntimeException("Model Transformer is null for " + model.getClass());
		}
		return modelTransformer.transform(model);
	}

	public <T, M> List<T> transform(List<M> models) {
		List<T> transformedList = Lists.newArrayList();
		models.stream().forEach(model -> transformedList.add(transform(model)));
		return transformedList;

	}
}
