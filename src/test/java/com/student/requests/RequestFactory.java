package com.student.requests;

import java.util.List;

import com.student.pojo.StudentClass;
import com.student.tests.TestBase;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestFactory extends TestBase {

	RestClient restClient = new RestClient();

	@Step("Getting all the student information from DB")
	public Response getAllStudents() {

		Response response = restClient.doGetRequest("/list");
		return response;
	}

	@Step("Creating a new student : {0} , {1} , {2}, {3} , {4}")
	public Response createNewStudent(String url, String firstName, String lastName, String email, String programme,
			List<String> courses) {

		StudentClass body = new StudentClass();
		body.setFirstName(firstName);
		body.setLastName(lastName);
		body.setEmail(email);
		body.setProgramme(programme);
		body.setCourses(courses);

		return restClient.doPostRequest(url, body);
	}

	@Step("Delete student with Id : {0}")
	public Response deleteStudent(int studentId) {

		return restClient.doDeleteRequest("/" + studentId);
	}

	@Step("Get student by ID : {0}")
	public Response getStudentById(int studentId) {

		return restClient.doGetRequest("/" + studentId);
	}

}
