	package com.crm.Listeners;
	
	import java.time.LocalDateTime;
	
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
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
	
	
	
	public class WtihExtentReports implements ITestListener {
	
	    public static ExtentSparkReporter spark = null;
	    public static ExtentReports report = null;
	    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	    @Override
	    public void onStart(ITestContext context) {
	        spark = new ExtentSparkReporter(".\\src\\test\\resources\\Reports\\executetest.html");
	        spark.config().setDocumentTitle("TestNG Listener Report");
	        spark.config().setReportName("Rahul");
	        spark.config().setTheme(Theme.DARK);
	
	        report = new ExtentReports();
	        report.setSystemInfo("Browser", "Chrome");
	        report.setSystemInfo("OS", "Windows 11");
	        report.attachReporter(spark);
	    }
	
	    @Override
	    public void onTestStart(ITestResult result) {
	        ExtentTest extentTest = report.createTest(result.getMethod().getMethodName());
	        test.set(extentTest);
	    }
	
	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.get().log(Status.PASS, result.getMethod().getMethodName() + " passed");
	    }
	
	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.get().log(Status.FAIL, result.getMethod().getMethodName() + " failed");
	
	        Object testClass = result.getInstance();
	        WebDriver driver = ((BaseClass) testClass).driver;
	
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        String base64 = ts.getScreenshotAs(OutputType.BASE64);
	        test.get().addScreenCaptureFromBase64String(base64);
	    }
	
	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.get().log(Status.SKIP, result.getMethod().getMethodName() + " skipped");
	    }
	
	    @Override
	    public void onFinish(ITestContext context) {
	        report.flush();
	    }
	}
