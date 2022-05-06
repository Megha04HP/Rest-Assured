package stepdefinations;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assignment3 {
    private Response response;
	@Test
	@Given("API for foreign exchange ")
	public void test_given_api() {
		RestAssured.baseURI = "https://reqres.in";
	}  
	
	@Test
	@When("passing values from get method")
	public void test_when_passing() {
		response = RestAssured.get("/api/users");   //store response into response object
	}
	
	@Test
	@Then("validate response received")
	public void test_then_validate() {
		
			Response response =
					given().log().all()
					.header("Content-Type", "application/json")
					.when().get("https://reqres.in/api/users?page=2")
					.then().log().all().statusCode(200).extract().response();
					Assert.assertEquals(200,response.getStatusCode());
					System.out.println("Status code is "+response.getStatusCode());
					String header = response.getHeader("Content-type");
					Assert.assertTrue(header.contains("application/json"));
					response.prettyPrint();
			}
	}

