package testScripts;

import java.io.IOException;
import ecommAppPack.EcommApplication;
import utility.ExtentReportsHelper;

public class PlaceOrderTestScript {

	public boolean tc_1234_PlaceOrderforIpod() throws IOException {
		boolean flag = false;

		try {

			ExtentReportsHelper.LogInfo("Test Case started : tc_1234_PlaceOrderforIpod");

			if (EcommApplication.yourStorePage().navigateToMp3Players()) {
				if (EcommApplication.mp3PlayersPage().clickOnMp3Player()) {
					if (EcommApplication.productDetailPage().clickOnAddToCartButton()) {
						if (EcommApplication.topToolbarPage().viewShoppingCart()) {
							if (EcommApplication.shoppingCartPage().navigateToCheckoutPage()) {
								if (EcommApplication.checkoutPage().checkoutTheOrder()) {
									ExtentReportsHelper.LogPass("Order successfully placed.");
									flag = true;
								} else {
									ExtentReportsHelper.LogFail("Failed to place order.");
								}
							} else {
								ExtentReportsHelper.LogFail("Failed to navigate to 'Checkout' page.");
							}
						} else {
							ExtentReportsHelper.LogFail("Failed to view shopping cart.");
						}
					} else {
						ExtentReportsHelper.LogFail("Failed to click on Add To Cart button.");
					}
				} else {
					ExtentReportsHelper.LogFail("Failed to select mp3 player.");
				}
			} else {
				ExtentReportsHelper.LogFail("Failed to navigate to mp3 players page.");
			}
		} catch (Exception e) {
			ExtentReportsHelper.LogFail("Exception while placing oder : " + e.getStackTrace());
		}
		return flag;
	}

}
