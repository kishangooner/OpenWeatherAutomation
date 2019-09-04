$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("OpenWeatherTests.feature");
formatter.feature({
  "line": 3,
  "name": "To perform end to end Tests on Open Weather Home page",
  "description": "",
  "id": "to-perform-end-to-end-tests-on-open-weather-home-page",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 32,
  "name": "Verifies the rest api",
  "description": "",
  "id": "to-perform-end-to-end-tests-on-open-weather-home-page;verifies-the-rest-api",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 31,
      "name": "@APIScenario"
    }
  ]
});
formatter.step({
  "line": 33,
  "name": "User submits the GET request \"\u003cparameter\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "validate status code \"\u003cstatusCode\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "validate the response content using \"\u003cjsonPath\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "line": 37,
  "name": "",
  "description": "",
  "id": "to-perform-end-to-end-tests-on-open-weather-home-page;verifies-the-rest-api;",
  "rows": [
    {
      "cells": [
        "parameter",
        "statusCode",
        "jsonPath"
      ],
      "line": 38,
      "id": "to-perform-end-to-end-tests-on-open-weather-home-page;verifies-the-rest-api;;1"
    },
    {
      "cells": [
        "London",
        "200",
        "name"
      ],
      "line": 39,
      "id": "to-perform-end-to-end-tests-on-open-weather-home-page;verifies-the-rest-api;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 71390400,
  "status": "passed"
});
formatter.scenario({
  "line": 39,
  "name": "Verifies the rest api",
  "description": "",
  "id": "to-perform-end-to-end-tests-on-open-weather-home-page;verifies-the-rest-api;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 31,
      "name": "@APIScenario"
    }
  ]
});
formatter.step({
  "line": 33,
  "name": "User submits the GET request \"London\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "validate status code \"200\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "validate the response content using \"name\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "London",
      "offset": 30
    }
  ],
  "location": "APISteps.get_request(String)"
});
formatter.result({
  "duration": 4914715899,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "APISteps.verify_status_code(int)"
});
formatter.result({
  "duration": 99584600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "name",
      "offset": 37
    }
  ],
  "location": "APISteps.response_equals(String)"
});
formatter.result({
  "duration": 651765200,
  "status": "passed"
});
formatter.after({
  "duration": 4998959200,
  "status": "passed"
});
});