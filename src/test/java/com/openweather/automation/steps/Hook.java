package com.openweather.automation.steps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.Scenario;
import com.openweather.automation.pages.OpenWeatherTestsHomePage;
import com.openweather.automation.pages.WeatherInYourCityPage;
import com.openweather.automation.utils.BaseUtil;


public class Hook extends BaseUtil{

    @Before
    public void InitializeTest(Scenario scenario) {
    	scenarioDef = BaseUtil.features.createNode(scenario.getName());
        System.out.println("Opening the browser : Chrome");
        System.setProperty("webdriver.chrome.driver",
        		  "D:\\Selenium\\chromedriver_win32\\chromedriver.exe"
        		  );
        Driver = new ChromeDriver();
        openWeatherTestsHomePage=new OpenWeatherTestsHomePage(Driver);
        weatherInYourCityPage=new WeatherInYourCityPage(Driver);
    }


    @After
    public void TearDownTest() {
        System.out.println("Closing the browser : Chrome");
        Driver.close();
    }

}
