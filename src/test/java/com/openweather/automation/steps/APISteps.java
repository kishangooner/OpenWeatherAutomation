package com.openweather.automation.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;

import com.aventstack.extentreports.GherkinKeyword;
import com.jayway.jsonpath.JsonPath;
import com.openweather.automation.utils.BaseUtil;

import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import com.openweather.automation.utils.BaseUtil;

public class APISteps extends BaseUtil{

	static Logger log = Logger.getLogger(APISteps.class);
	public String cityName;
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
    private String URI = "https://samples.openweathermap.org/data/2.5/weather?appid=b6907d289e10d714a6e88b30761fae22";
 
	@Given("^User submits the GET request \"([^\\\"]*)\"$")
	public void get_request(String cityName) throws ClassNotFoundException{
		scenarioDef.createNode(new GherkinKeyword("Given"),"User submits the GET request"+cityName);
		this.cityName=cityName;
		request = RestAssured.given().param("q", cityName);
		response = request.when().get(URI);
		System.out.println("response: " + response.prettyPrint());
	}
 
	@Then("^validate status code \"([^\\\"]*)\"$")
	public void verify_status_code(int statusCode) throws ClassNotFoundException{
		scenarioDef.createNode(new GherkinKeyword("Then"),"validate status code"+statusCode);
		response.then().assertThat().statusCode(statusCode);
	}
 
	
	@And("validate the response content using \"([^\\\"]*)\"$")
	public void response_equals(String jsonPath) throws ClassNotFoundException{
		scenarioDef.createNode(new GherkinKeyword("Then"),"validate the response content using "+jsonPath);
		response.then().assertThat().body(jsonPath,is(cityName));
	}
	
	

	@Then("^validate header parameter in response$")
	public void validate_header_parameter_in_response() throws InterruptedException, ClassNotFoundException {
		scenarioDef.createNode(new GherkinKeyword("Then"),"validate header parameter in response");
		response.then().assertThat().header("Content-Type","application/json; charset=utf-8");
	}

}
