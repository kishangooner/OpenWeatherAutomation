$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("OpenWeatherTests.feature");
formatter.feature({
  "line": 3,
  "name": "To perform end to end Tests on Open Weather Home page",
  "description": "",
  "id": "to-perform-end-to-end-tests-on-open-weather-home-page",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 12,
  "name": "Verifies that website suggests city is Not Found when we enter invalid city name.",
  "description": "",
  "id": "to-perform-end-to-end-tests-on-open-weather-home-page;verifies-that-website-suggests-city-is-not-found-when-we-enter-invalid-city-name.",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 11,
      "name": "@NegativeScenario"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "Navigate to Open Weather home page",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "User searches \"\u003ccityName\u003e\" for weather details",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "Verifies that website suggests city is Not Found Message",
  "keyword": "Then "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "to-perform-end-to-end-tests-on-open-weather-home-page;verifies-that-website-suggests-city-is-not-found-when-we-enter-invalid-city-name.;",
  "rows": [
    {
      "cells": [
        "cityName"
      ],
      "line": 18,
      "id": "to-perform-end-to-end-tests-on-open-weather-home-page;verifies-that-website-suggests-city-is-not-found-when-we-enter-invalid-city-name.;;1"
    },
    {
      "cells": [
        "Lacazette"
      ],
      "line": 19,
      "id": "to-perform-end-to-end-tests-on-open-weather-home-page;verifies-that-website-suggests-city-is-not-found-when-we-enter-invalid-city-name.;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5345704000,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Verifies that website suggests city is Not Found when we enter invalid city name.",
  "description": "",
  "id": "to-perform-end-to-end-tests-on-open-weather-home-page;verifies-that-website-suggests-city-is-not-found-when-we-enter-invalid-city-name.;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 11,
      "name": "@NegativeScenario"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "Navigate to Open Weather home page",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "User searches \"Lacazette\" for weather details",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "Verifies that website suggests city is Not Found Message",
  "keyword": "Then "
});
formatter.match({
  "location": "OpenWeatherTestsStepDefinitions.givenNavigatetoOpenWeatherhomepage()"
});
formatter.result({
  "duration": 58411626301,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Lacazette",
      "offset": 15
    }
  ],
  "location": "OpenWeatherTestsStepDefinitions.whenUserSearchescityNameForWeather(String)"
});
formatter.result({
  "duration": 2934033100,
  "status": "passed"
});
formatter.match({
  "location": "OpenWeatherTestsStepDefinitions.verifiesthatWebsiteSuggestsCityIsNotFoundMessage()"
});
formatter.result({
  "duration": 183662900,
  "status": "passed"
});
formatter.after({
  "duration": 2217737100,
  "status": "passed"
});
});