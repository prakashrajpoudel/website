package org.government.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

import org.government.api.Entity;
import org.government.api.Experiment;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

public abstract class JSONFileRepository<T extends Entity> {
	private static final Logger LOGGER = LoggerFactory.getLogger(JSONFileRepository.class);

	private static final String FILENAME = "person.json";
	private ObjectMapper mapper;
	private String fileName;

	public List<T> loadAll() {
		mapper = new ObjectMapper();
		Scanner scan = null;
		try {
			scan = new Scanner(new File(getFileName()));
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				Map<String, Object> userData = mapper.readValue(line, Map.class);
				userData.entrySet().forEach(entry -> {
					try {
						LOGGER.info("{}", entry.getValue());
						addEntity((String) entry.getValue());
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(scan)) {
				scan.close();
			}
		}
		return getAll();
	}

	protected abstract List<T> getAll();

	protected abstract void addEntity(String jsonString);

	public T save(T entity) {
		mapper = new ObjectMapper();
		JSONObject obj = new JSONObject();
		if (Objects.isNull(entity.getObjectUUID())) {
			entity.setObjectUUID(UUID.randomUUID());
		}
		try {
			obj.put(entity.getObjectUUID(), mapper.writeValueAsString(entity));
			BufferedWriter writer = new BufferedWriter(new FileWriter(getFileName(), true));
			writer.write(obj.toJSONString());
			writer.newLine();
			writer.flush();
			writer.close();
		} catch (JsonProcessingException e1) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entity;
	}

	protected String getFileName() {
		return Objects.isNull(fileName) ? FILENAME : fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	protected ObjectMapper getMapper() {
		return mapper;
	}
}
