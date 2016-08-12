package org.government.test;

import static io.restassured.RestAssured.given;

import java.util.UUID;

import static io.restassured.RestAssured.get;

import org.apache.commons.lang3.StringUtils;
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

	@Test
	public void updateResidence() {
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
		JSONObject jsonObject = new JSONObject();
		String objectUUID = (String) jsonObjectresponse.get("id");
		Assert.assertNotNull(objectUUID);
		for (String name : JSONObject.getNames(jsonObjectresponse)) {
			if (StringUtils.equalsIgnoreCase(name, "name")) {
				jsonObject.put(name, jsonObjectresponse.get(name).toString() + jsonObjectresponse.get("id").toString());
			} else {
				jsonObject.put(name, jsonObjectresponse.get(name));
			}
		}
		given().contentType("application/json").body(jsonObject.toString()).put("/api/residence");
		response = get("/api/residence/" + objectUUID);
		jsonObjectresponse = new JSONObject(response.asString());
		String age = (String) jsonObjectresponse.get("age");
		String gender = (String) jsonObjectresponse.get("gender");
		String name = (String) jsonObjectresponse.get("name");
		Assert.assertEquals(residenceTestDTO.age, age);
		Assert.assertEquals(residenceTestDTO.gender, gender);
		Assert.assertEquals(residenceTestDTO.name + objectUUID.toString(), name);
	}

	@Test
	public void deleteResidence() {
		ResidenceTestDTO residenceTestDTO = new ResidenceTestDTO();
		residenceTestDTO.age = "23";
		residenceTestDTO.gender = "Male";
		residenceTestDTO.name = "Sample";
		Response response = given().contentType("application/json").body(residenceTestDTO.toString())
				.post("/api/residence");
		JSONObject jsonObjectresponse = new JSONObject(response.asString());
		String objectUUID = (String) jsonObjectresponse.get("id");
		response = given().contentType("application/json").body(residenceTestDTO.toString())
				.delete("/api/residence/" + objectUUID);
		response = get("/api/residence/" + objectUUID);
		jsonObjectresponse = new JSONObject(response.asString());
		String statusCode = jsonObjectresponse.get("status").toString();
		Assert.assertEquals(statusCode, "500");
	}

	class ResidenceTestDTO {
		String name;
		String age;
		String gender;
		UUID id;
		String paid;
		String paidDate;

		@Override
		public String toString() {
			return "{\"name\":\"" + name + "\", \"age\":\"" + age + "\", \"gender\":\"" + gender + "\"}";
		}
	}
}
