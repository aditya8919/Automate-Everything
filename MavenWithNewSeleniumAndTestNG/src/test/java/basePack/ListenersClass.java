package basePack;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import ecommAppPack.EcommApplication;
import utility.ConfigOps;
import utility.ExtentReportsHelper;

public class ListenersClass implements ITestListener{
	
	public static String currentTestName;

	public void onTestStart(ITestResult result) 
	{
		try
		{
			String testName = result.getName();
			currentTestName = testName;
			BaseTest.extentReportsHelper = new ExtentReportsHelper(SeleniumWebDriver.driver, currentTestName);
			ExtentReportsHelper.StartTest(testName);
			ExtentReportsHelper.LogInfo("Starting Test Case execution : " + testName);

			SeleniumWebDriver.GotoURL(ConfigOps.ReadConfig("testsiteurl"));
			
			if(EcommApplication.loginPage().login())
				ExtentReportsHelper.LogPass("Login Successful.");
			else 
				ExtentReportsHelper.LogFail("Failed to login.");
		} 
		catch (Exception e) 
		{
			ExtentReportsHelper.LogInfo("Exception while login : "+e.getStackTrace());
		}
	}

	public void onTestSuccess(ITestResult result) {
		
		try {
			EcommApplication.loginPage().logout();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentReportsHelper.EndTest();
	}

	public void onTestFailure(ITestResult result) {
		
		try 
		{
			EcommApplication.loginPage().logout();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		ExtentReportsHelper.EndTest();
	}

	public void onTestSkipped(ITestResult result) {
		
		try {
			EcommApplication.loginPage().logout();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentReportsHelper.EndTest();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		
		System.out.println("onStart : " +context.getName());
	}

	public void onFinish(ITestContext context) {
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
