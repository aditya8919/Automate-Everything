package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsHelper {
	
	   private static ExtentReports extent;
	   public static ExtentTest extentTest;
	   static String reportFolderPath;
	   static String reportPath;
	   static WebDriver driver;

	   public ExtentReportsHelper(WebDriver driver, String currentTestName) throws IOException
	   {
		 this.driver = driver;
		 reportPath = System.getProperty("user.dir") +  "\\TestResults";
	     reportFolderPath = reportPath + "\\TestResults" + ConfigOps.ReadConfig("dateTimeStamp");
	     File reportPath = new File(reportFolderPath + "\\" + currentTestName + ConfigOps.ReadConfig("dateTimeStamp") + ".html");
		 ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	   }

	   public static void StartTest(String testName)
	   {
	     extentTest = extent.createTest(testName);
	   }

	   public static void LogInfo(String message)
	   {
	     extentTest.log(Status.INFO, message);
	   }

	   public static void LogWarning(String message)
	   {
	     extentTest.log(Status.WARNING, message);
	   }

	   public static void LogPass(String message)
	   {
	     extentTest.log(Status.PASS, message);
	   }

	   public static void LogFail(String message) throws IOException
	   {
	     extentTest.log(Status.FAIL, message, CptureScreen(driver,"testSSName"));
	   }

	   public static void EndTest()
	   {
	     extent.flush();
	   }

	   private static Media CptureScreen(WebDriver driver, String screenShotName) throws IOException
	   {
	     TakesScreenshot ss = (TakesScreenshot)driver;
	      String screen = ss.getScreenshotAs(OutputType.BASE64);

	     return MediaEntityBuilder.createScreenCaptureFromBase64String(screen).build();
	   }
	 }


