package stepdefinations;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assignment1 {
		private Response response;
		@Test
		@Given("API for foreign exchange")
		public void api_for_foreign_exchange() {
		    System.out.println("Given");
		    RestAssured.baseURI = "https://reqres.in";
		}
        @Test
		@When("posted with correct Information")
		public void posted_with_correct_information() {
			 System.out.println("When");
			 response = RestAssured.get("/api/users");
		}
        @Test
		@Then("validate positive response code received")
		public void validate_positive_response_code_received() {
			 System.out.println("Then");
			 System.out.println(response.getStatusLine());
			

		}
	}


