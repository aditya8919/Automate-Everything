package testSuite;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import basePack.BaseTest;
import testScripts.RightColumnOptionsTestScript;

public class RightCloumnoptionsTestSuite extends BaseTest
{
	@Test
	public void TC_1234_editAccountTest() throws InterruptedException, IOException
	{
		Assert.assertTrue(new RightColumnOptionsTestScript().tc_1234_performEditAccount());
	}
	
	@Test
	public void TC_1234_editPasswordTest() throws InterruptedException, IOException
	{
		Assert.assertTrue(new RightColumnOptionsTestScript().tc_12345_PerformEditPassword());
	}
	

}
