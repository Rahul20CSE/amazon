package com.crm.Listeners;

import java.io.File;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.BaseClass;

public class WtihExtentReport extends BaseClass implements ITestListener {
	public static ExtentSparkReporter spark=null;
	public static ExtentReports report = null;
	public static ExtentTest test=null;

	
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		  test= report.createTest(name);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
	    test.log(Status.PASS, name+"is success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	   	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = result.getMethod().getMethodName();
	    test.log(Status.FAIL, name+"is fial");
	    TakesScreenshot ts = (TakesScreenshot)driver;
	   	String from= ts.getScreenshotAs(OutputType.BASE64);
	   	test.addScreenCaptureFromBase64String(from);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
	    test.log(Status.SKIP, name+"is skip");
	    
	     
	   	
	}


	@Override
	public void onStart(ITestContext context) {
		//Creae entents SparkReporter
	    spark = new ExtentSparkReporter(".\\src\\test\\resources\\Reports\\suitlist.html");
		// Configure the extentSparkreporter
		spark.config().setDocumentTitle("Testing listener in suit");
		spark.config().setReportName("Rahul ");
		spark.config().setTheme(Theme.DARK);
		// Create ExtentRrport
	    report = new ExtentReports();
		// Set ExtentReport
		report.setSystemInfo("browser","Chrome-111");
		report.setSystemInfo("OS","Windosws-11");
		// attach ExtentReport
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		 report.flush();
	}

}
