package com.openweather.automation.reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.openweather.automation.utils.BaseUtil;
import com.openweather.automation.utils.ConstantData;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtil extends BaseUtil {

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    String fileName = ConstantData.reportLocation + "extentreport"+timeStamp+".html";

	    public void ExtentReport() {
	        extent = new ExtentReports();

	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setDocumentTitle(ConstantData.reportDocumentTitle);
	        htmlReporter.config().setEncoding(ConstantData.encoding);
	        htmlReporter.config().setReportName(ConstantData.reportName);

	        extent.attachReporter(htmlReporter);

	    }

	    public void ExtentReportScreenshot() throws IOException {

	        File scr = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
	        Files.copy(scr.toPath(), new File( ConstantData.reportLocation + "screenshot.png").toPath());
	        scenarioDef.fail("details").addScreenCaptureFromPath( ConstantData.reportLocation + "screenshot"+timeStamp+".png");
	    }


	    public void FlushReport(){
	        extent.flush();
	    }



}
