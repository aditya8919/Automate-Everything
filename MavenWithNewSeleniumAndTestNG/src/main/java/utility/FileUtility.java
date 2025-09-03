package utility;

import java.io.File;

public class FileUtility
{

	/**
	 * Method to verify if file is present at provided path or not
	 * @param filePath
	 */
	public static void fileExists(String filePath)
	{
		File file = new File(filePath);

		if (file.exists())
		{
			System.out.println("File exists at: " + filePath);
		}
		else
		{
			System.out.println("File does NOT exist at: " + filePath);
		}
	}


}
