package stepdefinations;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assignment8 {
	
	Response response;
	@DataProvider
	public Object[][]getData() {
	Object[][]data=new Object[1][1];
	data[0][0]="eve.holt@reqres.in";
	data[0][1]="cityslicka";
	return data;
	}
	@Test
	@Given("API for for login")
	public void api_for_for_login() {
	RestAssured.baseURI="https://reqres.in";
	} 
	@Test
	@When("posted with multiple set of data information")
	public void posted_with_multiple_set_of_data_information() {
	
	response= RestAssured.get("/api/login");
	} 
	@Test
	@Then("validate positive response code received from login page")
	public void validate_positive_response_code_received_from_login_page() {
	System.out.println(response.getStatusLine());
	Assert.assertEquals(200,response.getStatusCode());
	} public static void main(String args[]) {
	Response response =
	given().log().all()
	.header("Content-Type", "application/json")
	.when().get("https://reqres.in/api/login")
	.then().log().all().statusCode(200).extract().response();
	System.out.println("Status code is "+ response.getStatusCode());
	}
	
}
