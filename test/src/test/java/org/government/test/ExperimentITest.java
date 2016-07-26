package org.government.test;

import static io.restassured.RestAssured.get;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ExperimentITest {

	@Test
	public void shouldRetrieveUserData() {
		Response resp = get("/api/experiment");
		JSONObject jsonObjectresponse = new JSONObject(resp.asString());
		System.out.println(jsonObjectresponse.get("content"));
		String content = (String) jsonObjectresponse.get("content");
		Assert.assertEquals(content, "Test");
	}
}
