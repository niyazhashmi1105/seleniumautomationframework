package com.selenium.utils;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.selenium.enums.ConfigProperties;

import io.restassured.response.Response;

public final class ELKUtils {

	private ELKUtils() {}


	public static void sendResultstoELK(String testCaseName, String status) {


		if(PropertyUtils.get(ConfigProperties.SENDRESULTTOELK).equalsIgnoreCase("yes")) {
			Map<String, String> map = new HashMap<>();
			map.put("testCaseName", testCaseName);
			map.put("status", status);

			Response response = given().header("Content-Type","application/json")
					.log()
					.all()
					.body(map)
					.post(PropertyUtils.get(ConfigProperties.ELASTICURL));

			Assert.assertEquals(response.statusCode(), 201);

			response.prettyPrint();
		}
	}

}
