package com.openweather.automation.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/FeatureFile"} , plugin  = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
        glue = "com.openweather.automation.steps",tags = {"@APIScenario"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
