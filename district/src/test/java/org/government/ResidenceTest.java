package org.government;

import java.io.File;

import org.government.api.Residence;
import org.government.utils.JSONFileRepository;
import org.government.utils.ResidenceJSONFileRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResidenceTest {

	@Test
	public void testLoadAll() {
		Assert.assertEquals("Size is incorrect", 2, fileUtils().loadAll().size());
	}

	@Before
	public void saveResidence() {
		fileUtils().save(createResidence("Test", "11", "Male"));
		fileUtils().save(createResidence("Test2", "22", "Female"));
	}

	public JSONFileRepository<Residence> fileUtils() {
		JSONFileRepository<Residence> fileUtils = new ResidenceJSONFileRepository() {
			@Override
			protected String getFileName() {
				return "test.json";
			}
		};
		return fileUtils;
	}

	public Residence createResidence(String name, String age, String gender) {
		Residence residence = new Residence();
		residence.setAge(age);
		residence.setName(name);
		residence.setGender(gender);
		return residence;
	}

	@After
	public void deleteFile() {
		try {
			File file = new File("test.json");
			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}
		} catch (Exception e) {
		}
	}
}
