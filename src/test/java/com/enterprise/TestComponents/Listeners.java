package com.enterprise.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.enterprise.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);// unique thread id

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail("Test failed: " + result.getName());
		extentTest.get().fail(result.getThrowable());

		String filePath = null;
		try {
			// Get the active driver from the failed test class
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			Object testInstance = result.getInstance();

			// Make sure driver is not null before taking screenshot
			if (driver != null) {
				filePath = ((BaseTest) testInstance).getScreenshot(result.getMethod().getMethodName(), driver);
				extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
			} else {
				System.out.println("Driver was null — screenshot not taken.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test failed: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().skip("Test skipped: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush(); // important to write the report to file
	}
}
