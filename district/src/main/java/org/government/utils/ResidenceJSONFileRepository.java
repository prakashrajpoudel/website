package org.government.utils;

import java.io.IOException;
import java.util.List;

import org.government.api.Entity;
import org.government.api.Experiment;
import org.government.api.Residence;

import com.google.common.collect.Lists;

public class ResidenceJSONFileRepository extends JSONFileRepository {

	private List<Residence> allList;

	@Override
	public List<Residence> loadAll() {
		allList = Lists.newArrayList();
		return super.loadAll();
	}

	@Override
	protected List<Residence> getAll() {
		return allList;
	}

	@Override
	protected void addEntity(String jsonString) {
		try {
			allList.add(getMapper().readValue((String) jsonString, Residence.class));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected String getFileName() {
		return "residence.json";
	}

}
