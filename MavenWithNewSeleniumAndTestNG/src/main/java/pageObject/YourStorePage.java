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

public class YourStorePage 
{

	WebDriver driver;
	
	
	@FindBy(xpath = "//a[text()='MP3 Players']")
	WebElement btnMp3Players;
	
	@FindBy(xpath = "//a[text()='Show AllMP3 Players']")
	WebElement btnShowAllMp3Players;
	
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='MP3 Players']")
	List<WebElement> breadcrumbMp3PlayersByXpath;
	
	
	
	public YourStorePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // this keyword used for nonstatic variables
	}

	
	public boolean navigateToMp3Players() throws IOException
	{
		boolean flag = false;
		try 
		{
			SeleniumEventHelpers.MouseHover(btnMp3Players);
			ExplicitWait.waitUntilElementIsClickable(driver,btnShowAllMp3Players);
			SeleniumEventHelpers.DoClick(btnShowAllMp3Players);
			
			ExplicitWait.waitUntilElementIsVisible(driver,breadcrumbMp3PlayersByXpath.get(0));
			
			if(breadcrumbMp3PlayersByXpath.size() > 0)
			{
				ExtentReportsHelper.LogPass("Successfully navigated to 'Mp3 Players' page.");
				flag = true;
			}
			else 
			{
				ExtentReportsHelper.LogFail("Failed to navigate to 'Mp3 Players' page.");
			}
		} 
		catch (Exception e) 
		{
			ExtentReportsHelper.LogFail("Exception while navigating to 'Mp3 Players' page : " + e.getStackTrace());
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
