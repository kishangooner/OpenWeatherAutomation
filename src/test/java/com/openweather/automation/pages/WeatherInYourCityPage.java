package com.openweather.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.openweather.automation.utils.BaseUtil;
import com.openweather.automation.utils.ConstantData;
import com.openweather.automation.utils.ElementUtils;

public class WeatherInYourCityPage extends ElementUtils{
	
	Logger log = Logger.getLogger(WeatherInYourCityPage.class.getName());
	WebDriver driver;
	public WeatherInYourCityPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@class='alert alert-warning']")
	private WebElement cityNotFoundMessage;
	
	@FindBy(xpath="//span[text()='Weather in your city']")
	private WebElement weatherInYourCityLabel;
	
	@FindBy(xpath="//a[contains(@href,'/city/')]")
	private WebElement cityFoundText;
	
	public void verifyCityNotFoundErrorMessage() {
		if (verifyElementDisplayedOnPage(weatherInYourCityLabel) && verifyElementDisplayedOnPage(cityNotFoundMessage))
			Assert.assertTrue(cityNotFoundMessage.getText().contains(ConstantData.verifyCityNotFoundErrorMessage));
		else
		{
			Assert.fail(cityNotFoundMessage + "or" + weatherInYourCityLabel + "is not visisble");
			log.error(cityNotFoundMessage + "or" + weatherInYourCityLabel + "is not visisble");
		}
	}

	public void verifyCityWeatherDetails(String cityName) throws Exception {
		if (verifyElementDisplayedOnPage(cityFoundText) && verifyElementDisplayedOnPage(weatherInYourCityLabel))
		{
			Assert.assertTrue(cityFoundText.getText().toLowerCase().contains(cityName.toLowerCase()));
			cityFoundText.click();
			BaseUtil.openWeatherTestsHomePage.verifyWeatherDetails(cityName);
			log.info("Successfully verified the Weather Details for the City:"+cityName);
		}
		else
		{
			Assert.fail(cityFoundText + "or" + weatherInYourCityLabel + "is not visisble");
			log.error(cityFoundText + "or" + weatherInYourCityLabel + "is not visisble");
		}

	}
}
