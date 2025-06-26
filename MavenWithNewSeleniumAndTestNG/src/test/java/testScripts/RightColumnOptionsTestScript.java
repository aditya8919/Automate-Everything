package testScripts;

import java.io.IOException;
import ecommAppPack.EcommApplication;
import pageObject.EditAccountPage;
import utility.ExtentReportsHelper;

public class RightColumnOptionsTestScript
{
	public boolean tc_1234_performEditAccount() throws InterruptedException, IOException
	{

		boolean flag = false;

		try
		{
			Thread.sleep(40000);
			ExtentReportsHelper.LogInfo("Verifying 'Edit Account' functionality.");

			EditAccountPage.EditAccountPageVO editAccountPageVO = EcommApplication.editAccountPage().new EditAccountPageVO()
			{
				{
					fName = "ABC";
					lName = "XYZ";
					telephone = "123456";
				}
			};

			if (EcommApplication.editAccountPage().EditAcc(editAccountPageVO))
			{
				ExtentReportsHelper.LogPass("Account edited successfully.");
				flag = true;
			}
			else
			{
				ExtentReportsHelper.LogFail("Failed to edit account.");
			}
		}
		catch (Exception e)
		{
			ExtentReportsHelper.LogFail("Exception in TC_1234_performEditAccount method : " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}

	/**
	 * Method to perform Edit Password steps
	 * 
	 * @return true if password is changed successfully, else returns false.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public boolean tc_12345_PerformEditPassword() throws InterruptedException, IOException
	{
		boolean flag = false;
		try
		{
			ExtentReportsHelper.LogInfo("Verifying 'Edit Password' functionality.");

			if (EcommApplication.editPasswordPage().editPassword())
			{
				ExtentReportsHelper.LogPass("Password changed successfully.");
				flag = true;
			}
			else
			{
				ExtentReportsHelper.LogFail("Failed to change the password.");
			}
		}
		catch (Exception e)
		{
			ExtentReportsHelper.LogFail("Exception in performEditPassword method : " + e.getStackTrace());
		}
		return flag;
	}

}
