package com.openweather.automation.pages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.openweather.automation.steps.OpenWeatherTestsStepDefinitions;
import com.openweather.automation.utils.ElementUtils;

public class OpenWeatherTestsHomePage extends ElementUtils{

	Logger log = Logger.getLogger(OpenWeatherTestsHomePage.class.getName());
	
	@FindBy(xpath="//img[contains(@src,'logo')]")
	public WebElement openWeatherLogo;
	
	@FindBy(xpath="//span[text()='Support Center']")
	public WebElement supportCenterLabel;
	
	@FindBy(id="nav-search")
	public WebElement searchWeatherinCityBtn;
	
	@FindBy(xpath="//a[contains(@href,'sign_up') and @class='pull-right']")
	public WebElement signupBtn;
	
	@FindBy(xpath="//a[contains(@href,'sign_in') and @class='pull-right']")
	public WebElement signinBtn;
	
	@FindBy(xpath="//input[@id='q' and @placeholder='Your city name']")
	public WebElement searchCityNameTxt;
	
	@FindBy(xpath="//button[@type='submit' and @class='btn btn-orange']")
	public WebElement submitCityNameBtn;
	
	@FindBy(className="weather-widget__city-name")
	public WebElement cityNameLabel;
	
	@FindBy(className="weather-widget__temperature")
	public WebElement temparatureLabel;
	
	@FindBy(className="weather-widget__items")
	public WebElement weatherItemsLabel;
	
	@FindBy(id="tab-main")
	public WebElement mainTabBtn;
	
	@FindBy(id="tab-daily")
	public WebElement dailyTabBtn;
	
	@FindBy(id="tab-hourly")
	public WebElement hourlyTabBtn;
	
	@FindBy(id="tab-chart")
	public WebElement chartTabBtn;
	
	@FindBy(id="tab-map")
	public WebElement mapTabBtn;
	
	WebDriver driver;

	public OpenWeatherTestsHomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void verifyElementsArePresentOnHomePage() throws Exception
	{
		WebElement webElementArray[] = {openWeatherLogo, supportCenterLabel, cityNameLabel, temparatureLabel,
				weatherItemsLabel,searchCityNameTxt,searchWeatherinCityBtn, signupBtn, signinBtn,
				 submitCityNameBtn ,chartTabBtn,dailyTabBtn,hourlyTabBtn,mapTabBtn,mainTabBtn };
		Assert.assertTrue(verifyElementsDisplayedInPage(Arrays.asList(webElementArray)));
	}
	
	public void searchWeatherForCity(String cityName)
	{
		OpenWeatherTestsStepDefinitions.city_Name=cityName;
		
		if(verifyElementDisplayedOnPage(searchCityNameTxt)&&verifyElementDisplayedOnPage(searchWeatherinCityBtn))
		{
			searchCityNameTxt.sendKeys(cityName);
			submitCityNameBtn.click();
		}
		else
			log.error(searchCityNameTxt+"or"+searchWeatherinCityBtn+"webelement is not visible on the page");
		
	}
	
}
