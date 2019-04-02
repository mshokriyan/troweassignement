package stepDef;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinications {

	@When("User Input valid country {string}")
	public void user_Input_valid_country(String entryCountry) {

		Library.setURLConnection(entryCountry);

	}

	@Then("API Status code should be status Code {string}")
	public void api_Status_code_should_be_status_Code(String statusCode) {
		int code = Library.getResponseCode();
		String actualCode = String.valueOf(code);
		Assert.assertEquals(statusCode, actualCode);
	}

	@Then("Capital City Should be capital city {string}")
	public void capital_City_Should_be_capital_city(String expectedCapital) {
		String ActualCapital = Library.getCapitalCity();
		Assert.assertEquals(expectedCapital, ActualCapital);
	}

}
