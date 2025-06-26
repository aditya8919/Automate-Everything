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

public class TopToolbarPage 
{

	WebDriver driver;
	
	
	@FindBy(xpath = "//div[@id='cart']")
	WebElement btnCart;
	
	@FindBy(xpath = "//p[@class='text-right']//i[contains(@class,'fa-shopping-cart')]//..")
	WebElement btnViewCart;
	
	@FindBy(xpath = "//a[text()='Shopping Cart']")
	List<WebElement> breadcrumbShoppingCart;
	
	
	
	
	public TopToolbarPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // this keyword used for nonstatic variables
	}

	
	public boolean viewShoppingCart() throws IOException
	{
		boolean flag = false;
		try 
		{
			SeleniumEventHelpers.DoClick(btnCart);
			ExplicitWait.waitUntilElementIsClickable(driver,btnViewCart);
			
			SeleniumEventHelpers.DoClick(btnViewCart);
			
			ExplicitWait.waitUntilElementIsVisible(driver,breadcrumbShoppingCart.get(0));
			
			if(breadcrumbShoppingCart.size() > 0)
			{
				ExtentReportsHelper.LogPass("Successfully navigated to Shopping Cart.");
				flag = true;
			}
			else 
			{
				ExtentReportsHelper.LogFail("Failed to navigate to Shopping Cart.");
			}
		} 
		catch (Exception e) 
		{
			ExtentReportsHelper.LogFail("Exception while navigating to Shopping Cart : " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}
}
