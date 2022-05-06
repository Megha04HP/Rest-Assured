package stepdefinations;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assignment7 {
	
	Response response;
	
	@Test
	@Given("API for foreign exchange ")
	public void test_given() {
		RestAssured.baseURI = "https://reqres.in";
	}
	
	@Test
	@When("posted with future date Information")
	public void test_when_posted() {
		response = RestAssured.get("/api/2022-05-26");   //store response into response object
		
	}
	
	@Test
	@Then("validate response status code received")
	public void test_then_validate() {
		
		Response response =
				given().log().all()
				.header("Content-Type", "application/json")
				.get("/api/2022-05-26")
				.then().log().all().statusCode(200).extract().response();
		Assert.assertEquals(404,response.getStatusCode());
		System.out.println("Status code is "+ response.getStatusCode());
		String text = response.getStatusLine();
		Assert.assertTrue(text.contains("Bad Request"));  //asserting response status 
		System.out.println(text);
	}

}

