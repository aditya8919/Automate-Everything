package testSuite;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import basePack.BaseTest;
import testScripts.PlaceOrderTestScript;

public class PlaceOrderTestSuite extends BaseTest
{
	
	@Test
	public void TC_1234_placeOrderTest() throws InterruptedException, IOException
	{
		Assert.assertTrue(new PlaceOrderTestScript().tc_1234_PlaceOrderforIpod());
	}
	
	

}
