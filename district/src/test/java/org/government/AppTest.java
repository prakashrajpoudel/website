package org.government;

import java.io.File;


import org.government.api.Experiment;
import org.government.utils.ExperimentJSONFileRepository;
import org.government.utils.JSONFileRepository;
import org.junit.After;
import org.junit.Before;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {

		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static junit.framework.Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	@org.junit.Test
	public void testAllApp() {
		assertEquals("Size is incorrect", 2, fileUtils().loadAll().size());
		assertTrue(true);
	}

	/**
	 * Rigourous Test :-)
	 */
	@Before
	public void saveExperiment() {
		fileUtils().save(createExperiment(0, "Test"));
		fileUtils().save(createExperiment(1, "Test1"));
	}

	private JSONFileRepository fileUtils() {
		JSONFileRepository fileUtils = new ExperimentJSONFileRepository();
		fileUtils.setFileName("test.json");
		return fileUtils;
	}

	private Experiment createExperiment(int index, String content) {
		return new Experiment(index, content);
	}

	@After
	private void deleteFile() {
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
