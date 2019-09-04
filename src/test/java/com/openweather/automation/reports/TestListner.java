package com.openweather.automation.reports;



import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.openweather.automation.steps.Hook;
import com.openweather.automation.utils.BaseUtil;



public class TestListner  implements ITestListener {
	  ExtentReportUtil extentReportUtil = new ExtentReportUtil();

		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			System.out.println("On Test Failure");
			
			try {
				if(!Hook.scenarioName.contains("api"))
					extentReportUtil.ExtentReportScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			 	System.out.println("On start");
		        extentReportUtil.ExtentReport();
		        extentReportUtil.features = extentReportUtil.extent.createTest(Feature.class,"Open Weather Tests");
			
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			System.out.println("On finish");
	        extentReportUtil.FlushReport();
		}

}