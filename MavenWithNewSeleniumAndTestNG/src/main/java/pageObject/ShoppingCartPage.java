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

public class ShoppingCartPage 
{

	WebDriver driver;
	
	
	@FindBy(xpath = "//a[text()='Checkout']")
	WebElement btnCheckout;
	
	@FindBy(xpath = "//a[text()='Checkout']")
	List<WebElement> breadCrumbCheckout;
	
	
	public ShoppingCartPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // this keyword used for nonstatic variables
	}

	
	public boolean navigateToCheckoutPage() throws IOException
	{
		boolean flag = false;
		try 
		{
			SeleniumEventHelpers.ScrollTo(driver,btnCheckout);
			SeleniumEventHelpers.DoClick(btnCheckout);

			
			ExplicitWait.waitUntilElementIsVisible(driver,breadCrumbCheckout.get(0));
			
			if(breadCrumbCheckout.size() > 0)
			{
				ExtentReportsHelper.LogPass("Successfully navigated to 'Checkout' page.");
				flag = true;
			}
			else 
			{
				ExtentReportsHelper.LogFail("Failed to navigate to 'Checkout' page.");
			}
		} 
		catch (Exception e) 
		{
			ExtentReportsHelper.LogFail("Exception while navigating to 'Checkout' page : " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}
}
