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

public class CheckoutPage 
{

	WebDriver driver;
	
	
	@FindBy(xpath = "//input[@id='button-payment-address']")
	WebElement btnContinuePaymentAddr;
	
	@FindBy(xpath = "//input[@id='button-shipping-address']")
	WebElement btnContinueShippingAddr;
	
	@FindBy(xpath = "//input[@id='button-shipping-method']")
	WebElement btnContinueShippingMethod;
	
	@FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
	WebElement chkbxAgreeTerms;
	
	@FindBy(xpath = "//input[@id='button-payment-method']")
	WebElement btnContinuePaymentMethod;
	
	@FindBy(xpath = "//input[@id='button-confirm']")
	WebElement btnConfirmOrder;
	
	@FindBy(xpath = "//div[@id='common-success']//h1[text()='Your order has been placed!']")
	List<WebElement> msgOrderPlaced;
	
	
	public CheckoutPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // this keyword used for nonstatic variables
	}

	
	public boolean checkoutTheOrder() throws IOException
	{
		boolean flag = false;
		try 
		{
			SeleniumEventHelpers.ScrollTo(driver,btnContinuePaymentAddr);
			SeleniumEventHelpers.DoClick(btnContinuePaymentAddr);
			ExplicitWait.waitUntilElementIsClickable(driver,btnContinueShippingAddr);
			ExtentReportsHelper.LogPass("Clicked on Continue button for Payment address.");
			
			SeleniumEventHelpers.ScrollTo(driver,btnContinueShippingAddr);
			SeleniumEventHelpers.DoClick(btnContinueShippingAddr);
			ExplicitWait.waitUntilElementIsClickable(driver,btnContinueShippingMethod);
			ExtentReportsHelper.LogPass("Clicked on Continue button for delivery address.");
			
			SeleniumEventHelpers.ScrollTo(driver,btnContinueShippingMethod);
			SeleniumEventHelpers.DoClick(btnContinueShippingMethod);
			ExplicitWait.waitUntilElementIsClickable(driver,chkbxAgreeTerms);
			ExtentReportsHelper.LogPass("Clicked on Continue button for delivery method.");
			
			SeleniumEventHelpers.ScrollTo(driver,chkbxAgreeTerms);
			SeleniumEventHelpers.DoClick(chkbxAgreeTerms);
			ExplicitWait.waitUntilElementIsClickable(driver,btnContinuePaymentMethod);
			ExtentReportsHelper.LogPass("Clicked on checkbox to agree terms and conditions on for payment method.");
			
			SeleniumEventHelpers.DoClick(btnContinuePaymentMethod);
			ExplicitWait.waitUntilElementIsClickable(driver,btnConfirmOrder);
			ExtentReportsHelper.LogPass("Clicked on Continue button for payment method.");
			
			SeleniumEventHelpers.ScrollTo(driver,btnConfirmOrder);
			SeleniumEventHelpers.DoClick(btnConfirmOrder);
			ExplicitWait.waitUntilElementIsClickable(driver,msgOrderPlaced.get(0));
			ExtentReportsHelper.LogPass("Clicked on Confirm Order button.");
			
			if(msgOrderPlaced.size() > 0)
			{
				ExtentReportsHelper.LogPass("Order placed successfully.");
				flag = true;
			}
			else 
			{
				ExtentReportsHelper.LogFail("Failed to place order successfully..");
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
