package _6_Strings;

public class C1
{

	/**
	 * This method converts the case of each character in the input string.
	 * Uppercase letters are converted to lowercase and vice versa.
	 * 
	 * Time Complexity: O(n^2), where n is the length of the string. Because when we
	 * append characters to the string `conv`, it creates a new block of memory each
	 * time, copies the existing characters into that block, and then adds the new
	 * character; leading to O(n^2) complexity. Space Complexity: O(n), where n is
	 * the length of the string.
	 * 
	 * 
	 * To solve the problem more efficiently, we can use a StringBuilder Or we can
	 * convert the string to a character array and then solve it and again convert
	 * it to a string.
	 * 
	 * @param str The input string to be converted.
	 * 
	 * 
	 */
	public static void convertStringCase(String str)
	{
		String conv = "";

		for (int i = 0; i < str.length(); i++)
		{
			int ch = str.charAt(i);

			if (ch >= 65 && ch <= 90)
			{
				conv = conv + (char) (ch + 32);
			}
			else if (ch >= 97 && ch <= 122)
			{
				conv = conv + (char) (ch - 32);
			}
		}

		System.out.println(conv);
	}

	// abmadamas

	public static void longestPalindromeSubstring(String s)
	{
		int maxSubstringLength = 1;

		for (int i = 1; i < (s.length() - 1); i++)
		{
			char prev = s.charAt(i - 1);
			char next = s.charAt(i + 1);

			System.out.println("s.charAt(i) : " + s.charAt(i));

			while (prev == next && prev >= 0 && next < s.length())
			{
				maxSubstringLength += 2;

				prev--;
				next++;
			}

		}

		System.out.println(maxSubstringLength);

	}

	public static void main(String[] args)
	{
		convertStringCase("Hello World");

		System.out.println();
		System.out.println("******* longestPalindromeSubstring *******");
		System.out.println();

		longestPalindromeSubstring("abmadamas");
	}

}
