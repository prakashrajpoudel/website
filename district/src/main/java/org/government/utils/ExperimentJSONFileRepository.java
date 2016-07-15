package org.government.utils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.government.api.Experiment;

import com.google.common.collect.Lists;

public class ExperimentJSONFileRepository extends JSONFileRepository<Experiment> {
	
	private List<Experiment> allList;

	@Override
	public List<Experiment> loadAll() {
		allList = Lists.newArrayList();
		return super.loadAll();
	}
	@Override
	protected List<Experiment> getAll() {
		return allList;
	}

	@Override
	protected void addEntity(String jsonString) {
		try {
			allList.add(getMapper().readValue((String) jsonString, Experiment.class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
