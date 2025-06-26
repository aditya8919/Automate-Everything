package ecommAppPack;

import pageObject.EditAccountPage;
import pageObject.EditPasswordPage;
import pageObject.LoginPage;
import basePack.*;
import pageObject.*;

public class EcommApplication extends BaseTest
{
	
	private static EditAccountPage _editAccountPage;
	public static EditAccountPage editAccountPage()   // static method with className as return type
	{
		if(_editAccountPage == null)
		{
			_editAccountPage = new EditAccountPage(SeleniumWebDriver.driver);
		}
		return _editAccountPage;      
	}
	
	private static EditPasswordPage _editPasswordPage;
	public static EditPasswordPage editPasswordPage()
	{
		_editPasswordPage = new EditPasswordPage(SeleniumWebDriver.driver);
		return _editPasswordPage;
	}
	
	private static LoginPage _loginPage;
	public static LoginPage loginPage()
	{
		_loginPage = new LoginPage(SeleniumWebDriver.driver);
		return _loginPage;
	}
	
	private static CheckoutPage _checkoutPage;
	public static CheckoutPage checkoutPage()
	{
		_checkoutPage = new CheckoutPage(SeleniumWebDriver.driver);
		return _checkoutPage;
	}
	
	private static Mp3PlayersPage _mp3PlayersPage;
	public static Mp3PlayersPage mp3PlayersPage()
	{
		_mp3PlayersPage = new Mp3PlayersPage(SeleniumWebDriver.driver);
		return _mp3PlayersPage;
	}
	
	private static ProductDetailPage _productDetailPage;
	public static ProductDetailPage productDetailPage()
	{
		_productDetailPage = new ProductDetailPage(SeleniumWebDriver.driver);
		return _productDetailPage;
	}
	
	
	private static ShoppingCartPage _shoppingCartPage;
	public static ShoppingCartPage shoppingCartPage()
	{
		_shoppingCartPage = new ShoppingCartPage(SeleniumWebDriver.driver);
		return _shoppingCartPage;
	}
	
	private static TopToolbarPage _topToolbarPage;
	public static TopToolbarPage topToolbarPage()
	{
		_topToolbarPage = new TopToolbarPage(SeleniumWebDriver.driver);
		return _topToolbarPage;
	}
	
	private static YourStorePage _yourStorePage;
	public static YourStorePage yourStorePage()
	{
		_yourStorePage = new YourStorePage(SeleniumWebDriver.driver);
		return _yourStorePage;
	}
	
	

}
