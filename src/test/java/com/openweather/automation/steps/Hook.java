package com.openweather.automation.steps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.Scenario;
import com.openweather.automation.pages.OpenWeatherTestsHomePage;
import com.openweather.automation.pages.WeatherInYourCityPage;
import com.openweather.automation.utils.BaseUtil;


public class Hook extends BaseUtil{
public static String scenarioName;
    @Before
    public void InitializeTest(Scenario scenario) {
    	scenarioDef = BaseUtil.features.createNode(scenario.getName());
    	scenarioName=scenario.getName();
        System.out.println(scenarioName);
        System.setProperty("webdriver.chrome.driver",
        		  "D:\\Selenium\\chromedriver_win32\\chromedriver.exe"
        		  );
        if (!scenario.getName().contains("api"))
        	Driver = new ChromeDriver();
        openWeatherTestsHomePage=new OpenWeatherTestsHomePage(Driver);
        weatherInYourCityPage=new WeatherInYourCityPage(Driver);
    }


    @After
    public void TearDownTest() throws InterruptedException {
        System.out.println("Closing the browser : Chrome");
        if(Driver!=null)
        	Driver.quit();
        Thread.sleep(5000);
    }

}
