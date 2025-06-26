package basePack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import utility.ExtentReportsHelper;

public class SeleniumWebDriver extends BaseTest
{
	public static WebDriver driver;
	public static ChromeDriver chromeDriver;
	public static EdgeDriver edgeDriver;

	public class BrowserTypes
	{
		public static final String CHROME = "CHROME";
		public static final String EDGE = "EDGE";
		public static final String REMOTE = "REMOTE";
	}

	public static boolean createDriverinstance(String browserName) throws IOException, InterruptedException
	{
		boolean isDriverInstantiated = false;
		switch (browserName)
		{
		case BrowserTypes.CHROME:
		{
			driver = DriverOptions.GetChromeDriver();
			break;
		}
		case BrowserTypes.EDGE:
		{
			driver = DriverOptions.GetEdgeDriver();
			break;
		}
		
		case BrowserTypes.REMOTE:
		{
			driver = new RemoteWebDriver(
			    new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
			break;
		}
		

		default:
			throw new IllegalArgumentException("Unexpected value: " + browserName);
		
		}
		
		if(driver != null)
		{
			isDriverInstantiated = true;
		}
		return isDriverInstantiated;
	}

	public static class DriverOptions
	{
		public static ChromeDriver GetChromeDriver() throws IOException, InterruptedException
		{

			killProcessByName("chrome");
			chromeDriver = new ChromeDriver();
			SetImplicitWaitTime(10, chromeDriver);

			return chromeDriver;
		}

		public static EdgeDriver GetEdgeDriver() throws IOException, InterruptedException
		{

			killProcessByName("msedge");
			edgeDriver = new EdgeDriver();
			SetImplicitWaitTime(10, edgeDriver);

			return edgeDriver;
		}
	}

	public static void SetImplicitWaitTime(long timeInSeconds, WebDriver driver) throws IOException
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
		}
		catch (Exception ex)
		{
			ExtentReportsHelper.LogFail("Exception while setting Implicit Wait : " + ex.getStackTrace());
		}
	}

	public static Duration GetImplicitWaitTime() throws IOException
	{
		try
		{
			return driver.manage().timeouts().getImplicitWaitTimeout();
		}
		catch (Exception ex)
		{
			ExtentReportsHelper.LogFail("Exception while getting Implicit Wait : " + ex.getStackTrace());
			return null;
		}
	}

	public static void GotoURL(String url)
	{
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}

	public static void KillDriver() throws IOException
	{
		try
		{
			ExtentReportsHelper.LogInfo("Kill WebDriver Instanse");
			if (SeleniumWebDriver.driver != null)
			{
				SeleniumWebDriver.driver.quit();
				SeleniumWebDriver.driver = null;
			}
		}
		catch (WebDriverException webdriverException)
		{
			ExtentReportsHelper.LogInfo("WebdriverException found." + webdriverException.getStackTrace());
//	        if (webdriverException.StackTrace.Contains("OpenQA.Selenium.WebDriverException: disconnected: Unable to receive message from renderer (failed to check if window was closed: disconnected: not connected to DevTools)") && ConfigurationManager.AppSettings["BrowserType"] == BrowserType.EDGE)
//	        {
//	          SeleniumWebDriver.driver.Quit();
//	          SeleniumWebDriver.driver = null;
//	          HelperUtility.KillProcessByName("msedge");
//	        }
		}
		catch (Exception ex)
		{
			ExtentReportsHelper.LogInfo("Exeception occured in KillDriver() method.\n" + ex.getStackTrace());
		}
	}

	// ************

	public static void killProcessByName(String processName) throws IOException, InterruptedException
	{
		String osName = System.getProperty("os.name").toLowerCase();
		String command;

		if (osName.contains("windows"))
		{
			command = "tasklist";
		}
		else if (osName.contains("linux") || osName.contains("mac"))
		{
			command = "ps -e";
		}
		else
		{
			throw new UnsupportedOperationException("Unsupported operating system.");
		}

		Process proc = Runtime.getRuntime().exec(command);
		BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

		String line;
		while ((line = reader.readLine()) != null)
		{
			if (line.contains(processName))
			{
				String pid = extractPid(line, osName);

				if (osName.contains("windows"))
				{
					Runtime.getRuntime().exec("taskkill /F /PID " + pid);
				}
				else
				{
					Runtime.getRuntime().exec("kill -9 " + pid);
				}

//				System.out.println("Process " + pid + " (" + processName + ") terminated.");
			}
		}
		proc.waitFor();
	}

	private static String extractPid(String processLine, String osName)
	{
		if (osName.contains("windows"))
		{
			return processLine.split("\\s+")[1]; // Adjust this based on your `tasklist` output format
		}
		else
		{
			return processLine.split("\\s+")[0]; // Adjust this based on your `ps` output format
		}
	}

}
