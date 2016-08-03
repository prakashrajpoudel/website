package org.government;

import org.government.api.Residence;
import org.government.repository.ResidenceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jersey.repackaged.com.google.common.collect.Lists;

import static org.mockito.Mockito.*;

public class ResidenceTest {

	ResidenceRepository residenceRepository;

	@Test
	public void testLoadAll() {
		Assert.assertEquals("Size is incorrect", 2, residenceRepository.findAll().size());
	}

	@Before
	public void saveResidence() {
		residenceRepository = mock(ResidenceRepository.class);
		Residence residence1 = createResidence("Test", "11", "Male");
		when(residenceRepository.save(residence1)).thenReturn(null);
		residenceRepository.save(residence1);
		Residence residence2 = createResidence("Test2", "22", "Female");
		when(residenceRepository.save(residence2)).thenReturn(null);
		residenceRepository.save(residence2);
		when(residenceRepository.findAll()).thenReturn(Lists.newArrayList(residence1, residence2));
	}

	public Residence createResidence(String name, String age, String gender) {
		Residence residence = new Residence();
		residence.setAge(age);
		residence.setName(name);
		residence.setGender(gender);
		return residence;
	}
}
