package stepdefinations;

import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assignment5 {

	Response response;
	
	@Test
	@Given("API for foreign exchange ")
	public void test_given_api() {
		RestAssured.baseURI = "https://reqres.in";
	}
	
	@Test
	@When("posted with correct Information")
	public void test_when_posted() {
		response = RestAssured.given().get("/api/users");      //store response into response object
		
	}
	
	@Test
	@Then("validate response status code received")
	public void test_then_assert() {
		Response response =
		given().log().all()
		.header("Content-Type", "application/json")
		.when().get("https://reqres.in/api/users/23")
		.then().log().all().statusCode(404).extract().response();
		Assert.assertEquals(404,response.getStatusCode());
		System.out.println("Status code is "+ response.getStatusCode());
		
		}
}
