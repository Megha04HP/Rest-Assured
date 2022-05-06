package stepdefinations;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assignment2 {
	private Response response;
	@Test
	@Given("API for foreign exchange ")
	public void test_given_api() {
		RestAssured.baseURI = "https://reqres.in";
	}
	
	@Test
	@When("posted with correct Information")
	public void test_when_posted() {
		response = RestAssured.get("/api/users");       //store response into response object
	}
	
	@Test
	@Then("validate response and log it on console")
	public void test_then_log() {
		Response response =given().log().all()
				.header("Content-Type", "application/json")
				.when().get("https://reqres.in/api/users?page=2")
				.then().log().all().statusCode(200).extract().response();
		}
		    
}
