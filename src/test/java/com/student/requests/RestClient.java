package com.student.requests;

import com.student.specs.SpecificationFactory;
import com.student.tests.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClient extends TestBase {

	public Response doGetRequest(String requestPath) {
		return RestAssured.given().when().get(requestPath);
	}

	public Response doPostRequest(String uri, Object body) {

		return RestAssured.given().contentType(ContentType.JSON).spec(SpecificationFactory.logPayloadandResponseInfo())
				.body(body).post(uri);
	}

	public Response doPutRequest(String res, Object body) {

		return RestAssured.given().contentType(ContentType.JSON).when().body(body).put(res);
	}

	public Response doPatchRequest(String res, Object body) {
		Response response = RestAssured.given().when().body(body).patch(res);
		return response;

	}

	public Response doDeleteRequest(String res) {
		Response response = RestAssured.given().when().delete(res);
		return response;

	}

}
