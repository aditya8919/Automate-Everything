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

public class ProductDetailPage 
{

	WebDriver driver;
	
	
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement btnAddToCart;
	
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	List<WebElement> msgAlertSuccess;
	
	
	public ProductDetailPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // this keyword used for nonstatic variables
	}

	
	public boolean clickOnAddToCartButton() throws IOException
	{
		boolean flag = false;
		try 
		{
			SeleniumEventHelpers.DoClick(btnAddToCart);
			
			ExplicitWait.waitUntilElementIsVisible(driver,msgAlertSuccess.get(0));
			
			if(msgAlertSuccess.size() > 0)
			{
				ExtentReportsHelper.LogPass("Successfully clicked on 'Add To Cart' button.");
				flag = true;
			}
			else 
			{
				ExtentReportsHelper.LogFail("Failed to click on 'Add To Cart' button.");
			}
		} 
		catch (Exception e) 
		{
			ExtentReportsHelper.LogFail("Exception while clicking on 'Add To Cart' button : " + e.getStackTrace());
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
