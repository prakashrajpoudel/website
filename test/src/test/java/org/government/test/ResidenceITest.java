package org.government.test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResidenceITest {

	@Test
	public void addResidence() {
		/**
		 * { "name":"sample", "age":"23", "gender":"Male" }
		 */
		ResidenceTestDTO residenceTestDTO = new ResidenceTestDTO();
		residenceTestDTO.age = "23";
		residenceTestDTO.gender = "Male";
		residenceTestDTO.name = "Sample";
		Response response = given().contentType("application/json").body(residenceTestDTO.toString())
				.post("/api/residence");
		JSONObject jsonObjectresponse = new JSONObject(response.asString());
		String objectUUID = (String) jsonObjectresponse.get("id");
		Assert.assertNotNull(objectUUID);
		response = get("/api/residence/" + objectUUID);
		jsonObjectresponse = new JSONObject(response.asString());
		String age = (String) jsonObjectresponse.get("age");
		String gender = (String) jsonObjectresponse.get("gender");
		String name = (String) jsonObjectresponse.get("name");
		Assert.assertEquals(residenceTestDTO.age, age);
		Assert.assertEquals(residenceTestDTO.gender, gender);
		Assert.assertEquals(residenceTestDTO.name, name);
	}

	class ResidenceTestDTO {
		String name;
		String age;
		String gender;

		@Override
		public String toString() {
			return "{\"name\":\"" + name + "\", \"age\":\"" + age + "\", \"gender\":\"" + gender + "\"}";
		}

	}
}
