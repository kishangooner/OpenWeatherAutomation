package com.openweather.automation.reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.openweather.automation.utils.BaseUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtil extends BaseUtil {

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    String fileName = reportLocation + "extentreport"+timeStamp+".html";

	    public void ExtentReport() {
	        //First is to create Extent Reports
	        extent = new ExtentReports();

	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setDocumentTitle("Test report for Open Weather");
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName("Test report");

	        extent.attachReporter(htmlReporter);

	    }

	    public void ExtentReportScreenshot() throws IOException {

	        File scr = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
	        Files.copy(scr.toPath(), new File(reportLocation + "screenshot.png").toPath());
	        scenarioDef.fail("details").addScreenCaptureFromPath(reportLocation + "screenshot"+timeStamp+".png");
	    }


	    public void FlushReport(){
	        extent.flush();
	    }



}
