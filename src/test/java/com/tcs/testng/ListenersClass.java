package com.tcs.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenersClass implements ITestListener {
	
	ExtentReports extent;
	ExtentTest test;
	
	WebDriver driver;
	
	@Override
	public void onStart(ITestContext context) {
		
		ExtentSparkReporter spark =
                new ExtentSparkReporter("test-output/ExtentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        
		System.out.println("On Start Method Started...");
		
	}
	
	@Override
	public void onTestStart(ITestResult Result ) {
		test = extent.createTest(Result.getMethod().getMethodName());
		test.info("Test Started: " + Result.getName());
		System.out.println(Result.getName() + " test case started");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
		System.out.println("onFinish method started");
	}
	
	@Override
	public void onTestFailure (ITestResult Result) {
		
		 test.fail("Test Failed");
		 //test.fail(Result.getThrowable());

	        // Capture error message
	        if (Result.getThrowable() != null) {
	            test.fail("Error: " + Result.getThrowable().getMessage());
	        }

	        // Screenshot
	        if (driver != null) {

	            TakesScreenshot ts = (TakesScreenshot) driver;

	            String screenshot =
	                    ts.getScreenshotAs(OutputType.BASE64);

	            test.addScreenCaptureFromBase64String(
	                    screenshot,
	                    "Failure Screenshot"
	            );
	        }
		
		System.out.println("Test Failed: " + Result.getName());
	}
	
	
	
	@Override
    public void onTestSuccess(ITestResult Result) {
		 test.pass("Test Passed");
        System.out.println("Test Passed: " + Result.getName());
    }
	
	@Override
    public void onTestSkipped(ITestResult Result) {
		test.skip("Test Skipped");
        System.out.println("Test Skipped: " + Result.getName());
    }
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		  System.out.println("Test Failed But Within Success Percentage Test Method");

	}

}
