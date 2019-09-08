# OpenWeatherAutomation

### Selenium Framework with Cucumber

BDD framework for automation using Selenium Cucumber and TestNg

The framework has following features 

1. Modular Design
2. Maven based framework
3. Log4j enabled for logging
4. Report Generation (Extent- Report) 
5. Different page classes to handle web component such as (Button,Link etc)
6. Centralized Configuration (Using Properties file)
7. POM
8. Hooks for different browser support


### Add the Feature file 

Add the feature file under `test\resources\featurefile`

```java
Feature: To perform end to end Tests on Open Weather Home page
  @PositiveScenario
  Scenario Outline: Verifies that website successfully returns weather details for the valid city name.
  	Given Navigate to Open Weather home page
  	When User searches "<cityName>" for weather details
  	Then Verifies that website successfully returns weather details
  	
  	Examples:
  	|cityName|
  	|Mumbai|
```
### Here is the basic code of Steps:

This is the stepsDefinition class which supports the Feature file

```java
	@Then("^Verify that all the webelements are dispalyed on Open Weather Home page$")
  public void thenVerifyAlltheWebelementsArePresent() throws Exception{
	  scenarioDef.createNode(new GherkinKeyword("Then"),"Verify that all the webelements are dispalyed on Open Weather Home page");
	  openWeatherTestsHomePage.verifyElementsArePresentOnHomePage();
  }
```

### TestRunner class
This class Binds the feature file and Step definition class.

```java
@CucumberOptions(features = {"src/test/resources/FeatureFile"} , plugin  = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
        glue = "com.openweather.automation.steps",tags = {"@APIScenario"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
``` 

### Use the testng.xml file to run the test cases

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite" verbose="10" >
    <listeners>
        <listener class-name="com.openweather.automation.reports.TestListner" />
    </listeners>
    <test name="Open Weather Test Automation">
        <classes>
            <class name="com.openweather.automation.testrunner.TestRunner" />
        </classes>
    </test>
</suite>
```

### To see this whole thing running simply checkout this project and run this command:

Right Click on the Project and click on Run As > Maven Test
Or run the below command from cmd
`clean test`

### Extent Report

![Extent Report](https://github.com/kishangooner/OpenWeatherAutomation/blob/master/src/test/resources/extent-reports/ExtentReport.png)



