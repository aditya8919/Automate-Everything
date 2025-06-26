package pageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ConfigOps;
import utility.ExplicitWait;
import utility.ExtentReportsHelper;
import utility.SeleniumEventHelpers;

public class LoginPage {

	// Variables
	WebDriver driver;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement textBoxUserName;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement textBoxPassword;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement btnLogin;

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement btnLoginViaDropdown;

	@FindBy(xpath = "(//a[text()='Logout'])[1]")
	WebElement btnLogout;

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement btnMyAccountToLogin;

	@FindBy(xpath = "//a[@class='list-group-item' and text()='My Account']")
	WebElement btnMyAccount;

	@FindBy(xpath = "//h1[text()='Account Logout']")
	WebElement textMsgLogout;

	// Constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // this keyword used for nonstatic variables
	}

	// Methods

	public boolean login() throws IOException {
		
		boolean flag = false;
		try 
		{
			SeleniumEventHelpers.DoClick(btnMyAccountToLogin);
			ExplicitWait.waitUntilElementIsVisible(driver,btnLoginViaDropdown);

			SeleniumEventHelpers.DoClick(btnLoginViaDropdown);
			ExplicitWait.waitUntilElementIsVisible(driver,btnLogin);

			textBoxUserName.sendKeys(ConfigOps.ReadConfig("userID"));
			textBoxPassword.sendKeys(ConfigOps.ReadConfig("password"));
			btnLogin.click();

			if (ExplicitWait.waitUntilElementIsVisible(driver,btnMyAccount)) {
				ExtentReportsHelper.LogPass("Login Successful.");
				flag = true;
			} else {
				ExtentReportsHelper.LogFail("Login Failed.");
			}
		} 
		catch (Exception e) 
		{
			ExtentReportsHelper.LogFail("Exception while login : " + e.getStackTrace());
		}

		return flag;

	}

	public void logout() throws IOException 
	{
		try 
		{
			btnMyAccountToLogin.click();
			ExplicitWait.waitUntilElementIsClickable(driver,btnLogout);

			btnLogout.click();

			if (ExplicitWait.waitUntilElementIsVisible(driver,textMsgLogout)) 
			{
				ExtentReportsHelper.LogPass("Logout Successful.");
			} 
			else 
			{
				ExtentReportsHelper.LogFail("Logout Failed");
			}
		} 
		catch (Exception e) 
		{
			ExtentReportsHelper.LogFail("Exception while logout : " + e.getStackTrace());
		}
	}
}
