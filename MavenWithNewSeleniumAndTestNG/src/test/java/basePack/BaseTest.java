package basePack;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.testng.annotations.*;
import utility.ConfigOps;
import utility.ExtentReportsHelper;
import utility.SeleniumEventHelpers;

public class BaseTest {

//	public static WebDriver driver;
	public static ExtentReportsHelper extentReportsHelper;
	public static LocalDateTime time;
	static DateTimeFormatter formatter;
	private static String dateTimeStamp; 
	SeleniumEventHelpers seleniumEventHelpers;

	@BeforeSuite
	public void executionInitialization() throws IOException {
		
		// Xml file creation -- IMP Create properties file
		// Log/Report path selection 
		
		time = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("ddMMyyyy_HH_mm_ss");
		dateTimeStamp = "_" + time.format(formatter);
		ConfigOps.WriteConfig("dateTimeStamp", dateTimeStamp);
	}

//	@BeforeTest
//	public void testSetup() {
//		 Setup env details
//		 Start Logging
//		 Launch Browser
//		 Hit URL
//		 Login
//		String testName = xmlTest.getName();
//		Reporter.log("Test name is : " + testName);
//		ExtentReportsHelper.StartTest("testSetup method");
//		System.out.println("Starting Test Case execution : testSetup method");
//	}

	@BeforeMethod
	public void testSetUp() throws IOException, InterruptedException {
		
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();

		SeleniumWebDriver.createDriverinstance(ConfigOps.ReadConfig("browserType"));
		seleniumEventHelpers = new SeleniumEventHelpers(SeleniumWebDriver.driver);
	}

	@BeforeClass
	public void initobjects() {
//		 loginPageObject = new LoginPage(driver);
//		 editPassword = new EditPasswordPage(driver);
//		 editAccount = new EditAccountPage(driver);
	}

//	@AfterTest
//	public void endTestSetup() {
//		ExtentReportsHelper.EndTest();
//	}

	@AfterMethod           
	public void endTestSetup() throws IOException {

		SeleniumWebDriver.KillDriver();
	}

	@AfterSuite
	public void tearDown() {
//		driver.quit();
	}

}
