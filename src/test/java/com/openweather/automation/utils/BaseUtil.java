package com.openweather.automation.utils;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.openweather.automation.pages.OpenWeatherTestsHomePage;
import com.openweather.automation.pages.WeatherInYourCityPage;



public class BaseUtil {

    public static WebDriver Driver;
    public static OpenWeatherTestsHomePage openWeatherTestsHomePage;
    public static WeatherInYourCityPage weatherInYourCityPage;
    public ExtentReports extent;

    public static ExtentTest scenarioDef;

    public static ExtentTest features;

    public static String reportLocation = "D:\\Selenium";

}
