package pageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExplicitWait;
import utility.ExtentReportsHelper;

public class EditPasswordPage {
	
	WebDriver driver;
	
	@FindBy (xpath = "//a[text()='Password']")
	WebElement btnPassword;

	
	@FindBy (xpath = "//input[@id='input-password']")
	WebElement textPassword;

	
	@FindBy (xpath = "//input[@id='input-confirm']")
	WebElement textPasswordConf;
	
	@FindBy(xpath = "//input[@value = 'Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//div[contains(text(),'Success: Your password has been successfully updated.')]")
	WebElement msgSuccessAlert;
	
	public EditPasswordPage(WebDriver driver) 
	{

	this.driver = driver;
	PageFactory.initElements(driver,this);   // this keyword used for nonstatic variables
	}
	
	public boolean editPassword() throws InterruptedException, IOException
	{
		boolean flag = false;
		try {
			
			btnPassword.click();
			ExplicitWait.waitUntilElementIsVisible(driver, btnContinue);
			
			textPassword.sendKeys("Login@123");
			textPasswordConf.sendKeys("Login@123");
			
			
			btnContinue.click();
			
			if (msgSuccessAlert.isDisplayed()) 
			{
				ExtentReportsHelper.LogPass("Password successfully updated.");
				flag = true;
			} 
			else 
			{
				ExtentReportsHelper.LogFail("Failed to update Password.");
			}
		} 
		catch (Exception e) 
		{
			
			ExtentReportsHelper.LogFail("Exception in editPW method : " + e.getStackTrace());
		}
		
		return flag;
	}


	
	
	
	
	
	
	
	
	
	
}
