

Feature: To perform end to end Tests on Open Weather Home page

  @Scenario
  Scenario: Verify all the information is dispalyed on Open Weather Home page
    Given Navigate to Open Weather home page
    Then Verify that all the webelements are dispalyed on Open Weather Home page
    
  
  @NegativeScenario
  Scenario Outline: Verifies that website suggests city is Not Found when we enter invalid city name.
  	Given Navigate to Open Weather home page
  	When User searches "<cityName>" for weather details
  	Then Verifies that website suggests city is Not Found Message
  	
  	Examples:
  	|cityName|
  	|Lacazette|
  	
  @PositiveScenario
  Scenario Outline: Verifies that website successfully returns weather details for the valid city name.
  	Given Navigate to Open Weather home page
  	When User searches "<cityName>" for weather details
  	Then Verifies that website successfully returns weather details
  	
  	Examples:
  	|cityName|
  	|Mumbai|
  	
  	@APIScenario
  	Scenario Outline: Verifies the rest api
  	When User submits the GET request "<parameter>"
  	Then validate status code "<statusCode>"
  	And validate the response content using "<jsonPath>"
  	
  	Examples:
  	|parameter|statusCode|jsonPath|
  	|London		|200			 |name		|
  	
  	