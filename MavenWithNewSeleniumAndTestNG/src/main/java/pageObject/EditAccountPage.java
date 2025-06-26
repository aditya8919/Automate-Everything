package pageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ExplicitWait;
import utility.ExtentReportsHelper;
import utility.SeleniumEventHelpers;

public class EditAccountPage 
{

	WebDriver driver;
	
	private static final String btnEditAccByXpath = "//a[text() = 'Edit Account']";
	private static final String textBoxTelephoneByXpath = "//input[@id='input-telephone']";
	private static final String btnContinueByXpath = "//input[@value = 'Continue']";
	

	@FindBy(xpath = btnEditAccByXpath)
	private WebElement btnEditAcc;

	@FindBy(xpath = textBoxTelephoneByXpath)
	private WebElement textBoxTelephone;

	@FindBy(xpath = btnContinueByXpath)
	private WebElement btnContinue;

	@FindBy(xpath = "//div[contains(text(),'Success: Your account has been successfully updated.')]")
	WebElement msgSuccessAlert;

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement textBoxFName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement textBoxLName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement textboxEmail;
	
	
	public EditAccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this); // this keyword used for nonstatic variables
	}

	public boolean EditAcc(EditAccountPageVO editAccountPageVO) throws IOException 
	{
		boolean flag = false;
		try 
		{
//			btnEditAcc.click();
			SeleniumEventHelpers.DoClick(btnEditAcc);

			ExplicitWait.waitUntilElementIsVisible(driver,btnContinue);
			
			if(btnContinue.isDisplayed())
			{
				ExtentReportsHelper.LogInfo("Clicked on Edit Account button.");
			}
			

			if(editAccountPageVO.fName != null)
			{
				textBoxFName.clear();
				textBoxFName.sendKeys(editAccountPageVO.fName);
				ExtentReportsHelper.LogInfo("Entered value "+ editAccountPageVO.fName + " in First Name field.");
			}
				

			if(editAccountPageVO.lName != null)
			{
				textBoxLName.clear();
				textBoxLName.sendKeys(editAccountPageVO.lName);
				ExtentReportsHelper.LogInfo("Entered value '"+ editAccountPageVO.lName + "' in Last Name field.");
			}
				
			
			if(editAccountPageVO.telephone != null)
			{
				textBoxTelephone.clear();
				textBoxTelephone.sendKeys(editAccountPageVO.telephone);
				ExtentReportsHelper.LogInfo("Entered value '"+ editAccountPageVO.telephone + "' in Telephone field.");
			}
				
			
			if(editAccountPageVO.email != null)
			{
				textboxEmail.clear();
				textboxEmail.sendKeys(editAccountPageVO.email);
				ExtentReportsHelper.LogInfo("Entered value '"+ editAccountPageVO.email + "' in Email field.");
			}
				
			
			btnContinue.click();

			ExplicitWait.waitUntilElementIsVisible(driver,msgSuccessAlert);

			if (msgSuccessAlert.isDisplayed()) 
			{
				ExtentReportsHelper.LogPass("Account successfully updated.");
				flag = true;
			} 
			else 
			{
				ExtentReportsHelper.LogFail("Failed to update account.");
			}
			return flag;
		} 
		catch (Exception e) 
		{
			ExtentReportsHelper.LogFail("Exception in EditAcc method : " + e.getStackTrace());
			return flag;
		}
	}
	
	
	public class EditAccountPageVO
	{
		public String fName = null; 
		public String lName= null; 
		public String email= null; 
		public String telephone = null; 
		
	}
	
	
	
	
	

}
