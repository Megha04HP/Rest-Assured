package stepdefinations;


import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assignment4 {
	
	Response response;
	
	@Test
	@Given("API for foreign exchange ")
	public void test_given_api() {
		RestAssured.baseURI = "https://reqres.in";
	}
	
	@Test
	@When("posted with correct Information")
	public void test_when_posted() {
		response = RestAssured.get("/api/users");
		
	}
	
	@Test
	@Then("validate positive response code received")
	public void test_then_log() {
		
		Response response =given().log().all()
		//content is in json format
		.header("Content-Type", "application/json")
		.when().get("https://reqres.in/api/users/23")
		.then().log().all().statusCode(404).extract().response();
		System.out.println("Status code is "+ response.getStatusCode());
		}

	}
