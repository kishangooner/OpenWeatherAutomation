package com.openweather.automation.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.GherkinKeyword;
import com.openweather.automation.pages.OpenWeatherTestsHomePage;
import com.openweather.automation.pages.WeatherInYourCityPage;
import com.openweather.automation.utils.BaseUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class OpenWeatherTestsStepDefinitions extends BaseUtil{

public static String city_Name;
  @Given("^Navigate to Open Weather home page$")
  public void givenNavigatetoOpenWeatherhomepage() throws ClassNotFoundException{
	  scenarioDef.createNode(new GherkinKeyword("Given"),"Navigate to Open Weather home page");
	  Driver.get("https://openweathermap.org/");
	  Driver.manage().window().maximize();
  }

  @Then("^Verify that all the webelements are dispalyed on Open Weather Home page$")
  public void thenVerifyAlltheWebelementsArePresent() throws Exception{
	  scenarioDef.createNode(new GherkinKeyword("Then"),"Verify that all the webelements are dispalyed on Open Weather Home page");
	  openWeatherTestsHomePage.verifyElementsArePresentOnHomePage();
  }

  @When("^User searches \"([^\"]*)\" for weather details$")
  public void whenUserSearchescityNameForWeather(String cityName) throws ClassNotFoundException
  {
	  scenarioDef.createNode(new GherkinKeyword("When"),"User searches \"([^\"]*)\" for weather details");
	  openWeatherTestsHomePage.searchWeatherForCity(cityName);
  }
  
  @Then("^Verifies that website suggests city is Not Found Message$")
  public void verifiesthatWebsiteSuggestsCityIsNotFoundMessage() throws ClassNotFoundException
  {
	  scenarioDef.createNode(new GherkinKeyword("Then"),"Verifies that website suggests city is Not Found Message");
	  weatherInYourCityPage.verifyCityNotFoundErrorMessage();
  }
  
  
  @Then("^Verifies that website successfully returns weather details$")
  public void verifiesthatWebsiteSuccessfullyReturnsWeatherDetails() throws ClassNotFoundException
  {
	  scenarioDef.createNode(new GherkinKeyword("Then"),"Verifies that website successfully returns weather details");
	  weatherInYourCityPage.verifyCityWeatherDetails(city_Name);
  }
}
