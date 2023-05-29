package com.utilsLayer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerClass extends ExtentSetUp implements ITestListener{
	ExtentTest extentTest;
	
	public void onStart(ITestContext context) {
		ExtentSetUp.extentsetup();
	}

	public void onTestStart(ITestResult result) {
	extentTest = extentReports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test Case is passed "+result.getMethod().getMethodName());
		extentTest.addScreenCaptureFromPath(UtilsClass.takeScreenshot(result.getMethod().getMethodName()));
		
		
	}

	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "Test Case is failed "+result.getMethod().getMethodName());
		extentTest.addScreenCaptureFromPath(UtilsClass.takefailScreenshot(result.getMethod().getMethodName()));
//		extentTest.log(Status.FAIL, result.getThrowable()); // throw exception if test case is getting failed
		
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "Test Case is skipped "+result.getMethod().getMethodName());
		
	}	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

}
