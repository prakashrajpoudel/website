package org.government.model.mapper;

import org.modelmapper.ModelMapper;

public class ModelMapperConfiguration {
	private static ModelMapperConfiguration modelMapperConfiguration;
	private ModelMapper modelMapper;

	private ModelMapperConfiguration() {
	}

	public static ModelMapper getModelMapper() {
		if (modelMapperConfiguration == null) {
			modelMapperConfiguration = new ModelMapperConfiguration();
			modelMapperConfiguration.configureModelMapper();
		}
		return modelMapperConfiguration.modelMapper;
	}

	private void configureModelMapper() {

	}
}
