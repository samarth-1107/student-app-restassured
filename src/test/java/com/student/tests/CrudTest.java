package com.student.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;

@Story("This is a CRUD testing story")
public class CrudTest extends TestBase {

	RequestFactory requests = new RequestFactory();

	@Story("This is a CRUD testing story")
	@DisplayName("GetAllStudents")
	@Feature("This is a test to get all students from the Database")
	@Test
	public void getAllStudents() {

		requests.getAllStudents().then().spec(SpecificationFactory.getGenericResponseSpec()).statusCode(200);

	}

	@Story("This is a CRUD testing story")
	@DisplayName("CreateNewStudent")
	@Feature("This is a test to create new student")
	@Test
	public void createNewStudent() {

		Faker fakeData = new Faker();

		String firstName = fakeData.name().firstName();
		String lastName = fakeData.name().lastName();
		String email = fakeData.internet().emailAddress();
		String programme = "Computer Science";
		List<String> courses = new ArrayList<String>();
		courses.add("C++");
		courses.add("Java");

		requests.createNewStudent("", firstName, lastName, email, programme, courses).then()
				.spec(SpecificationFactory.getGenericResponseSpec()).statusCode(201);

	}

}
