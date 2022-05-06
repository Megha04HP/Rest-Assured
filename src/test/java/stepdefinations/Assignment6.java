package stepdefinations;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assignment6 {
	
	Response response;
	
	@Test
	@Given("API for foreign exchange ")
	public void test_given_api() {
		RestAssured.baseURI = "https://reqres.in";
	}
	
	@Test
	@When("posted with correct Information")
	public void test_when_posted() {
		response = RestAssured.get("/api/2022-05-26");
	}
	
	@Test
	@Then("validate positive response code received")
	public void test_then_validate() {
	Response response =
	given().log().all()
	.header("Content-Type", "application/json")
	.get("/api/2022-05-26")
	.then().log().all().statusCode(200).extract().response();
	
	}


}
