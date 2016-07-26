package com.sample.test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class ExperimentITest {

	@Test
	public void shouldRetrieveUserData() {
		when().get("/api/experiment").then().log().all().body(containsString("Test"));
	}
}
