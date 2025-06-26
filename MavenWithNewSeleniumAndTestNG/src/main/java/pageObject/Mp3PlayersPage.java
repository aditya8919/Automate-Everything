package pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExplicitWait;
import utility.ExtentReportsHelper;
import utility.SeleniumEventHelpers;

public class Mp3PlayersPage 
{

	WebDriver driver;
	
	
	@FindBy(xpath = "//div[@class='product-thumb']//img[@title='iPod Touch']")
	WebElement btnIpodTouch;
	
	@FindBy(xpath = "//ul[@class='list-unstyled']//li[contains(text(),'Product Code')]")
	List<WebElement> listIpodInfo;
	
	
	
	
	
	public Mp3PlayersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // this keyword used for nonstatic variables
	}

	
	public boolean clickOnMp3Player() throws IOException
	{
		boolean flag = false;
		try 
		{
			SeleniumEventHelpers.DoClick(btnIpodTouch);
			
			ExplicitWait.waitUntilElementIsVisible(driver,listIpodInfo.get(0));
			
			if(listIpodInfo.size() > 0)
			{
				ExtentReportsHelper.LogPass("Successfully clicked on 'Mp3 Player'.");
				flag = true;
			}
			else 
			{
				ExtentReportsHelper.LogFail("Failed to click on 'Mp3 Player'.");
			}
		} 
		catch (Exception e) 
		{
			ExtentReportsHelper.LogFail("Exception while clicking on 'Mp3 Player' : " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}
	
	
	public class EditAccountPageVO
	{
		public String fName = null; 
		public String lName= null; 
		public String email= null; 
		public String telephone = null; 
		
	}
	
	
	
	
	

}
