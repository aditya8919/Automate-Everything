package _1_logicalProbs;

public class Logical
{

	/**
	 * Method to get the factors of any number n
	 * 
	 * NOTE: Range of factors of any number n is from 1 to n 1 and n are always
	 * factors of n
	 * 
	 * @param n
	 */
	public static void printFactors(int n)
	{
		for (int i = 1; i <= n; i++)
		{
			if ((n % i) == 0)
			{
				System.out.println(i);
			}
		}
	}
	
	/**
	 * Optimized approach to find out factors of any number.
	 * For any number n; i, j are said to be factors when "i * j = n"
	 * where j = n/i.
	 * Hence factors always come into pairs. 
	 * For perfect square nums, we can count that factor as 1 i.e. i == j.
	 * @param n
	 */
	public static void printFactorsOptimized(int n)
	{
		for (int i = 1; i * i <= n; i++)
		{
			if ((n % i) == 0)
			{
				if(i == n/i)
				{
					System.out.println(i);
				}
				else
				{
					System.out.println(i + " and " + n/i);
				}
			}
		}
	}

	/**
	 * Method to check if given number is prime or not
	 * 
	 * NOTE: Any number n is prime iff, it has exactly 2 factors; 1 and itself. 1 is
	 * not prime coz it has only 1 factor which is itself.
	 * 
	 * Find out if any number from 2 to n/2 is a factor of n or not. If there is a
	 * number from 2 to n/2 which is a factor of n; then n is not prime, else n is
	 * prime.
	 * 
	 * @param n
	 */
	public static void isPrime(int n)
	{
		int factorCount = 0;
		if (n == 1)
		{
			System.out.println("Not Prime");
			return;
		}

		for (int i = 2; i <= (n / 2); i++)
		{
			if ((n % i) == 0)
			{
				factorCount += 1;
				break;
			}
		}

		if (factorCount != 0)
		{
			System.out.println("Not Prime");
		}
		else
		{
			System.out.println("Prime");
		}
	}

	public static int reverseNum(int n)
	{
		int num = n;
		int lastDigit = -1;
		int revNum = 0;

		while (num != 0)
		{
			lastDigit = num % 10; // to separate last digit of any num

			revNum = (revNum * 10) + lastDigit; // to add any num to right of any number.

			num = num / 10;
		}

//		System.out.println(revNum);

		return revNum;
	}

	/**
	 * Palindrome : if number is reversed, its same as original num. Ex: 151
	 * 
	 * @param n
	 */
	public static void isPalindrome(int n)
	{
		// Negative numbers and numbers ending in 0 (except 0 itself) are not
		// palindromes
		if (n < 0 || (n % 10 == 0 && n != 0))
		{
			System.out.println("Not Palindrome");
			return;
		}

		if (reverseNum(n) == n)
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not Palindrome");
		}
	}

	public static void isPalindromeOptimized(int n)
	{
		int reversedHalf = 0;
		int lastDigit = 0;
		int num = n;

		// Negative numbers and numbers ending in 0 (except 0 itself) are not
		// palindromes
		if (num < 0 || (num % 10 == 0 && num != 0))
		{
			System.out.println("Not Palindrome");
			return;
		}

		while (num > reversedHalf)
		{
			lastDigit = num % 10;

			reversedHalf = (reversedHalf * 10) + lastDigit;

			num = num / 10;

		}

		if ((num == reversedHalf) || (num == (reversedHalf / 10)))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not Palindrome");
		}
	}

	public static void isStringPalindrome(String s)
	{
		String rev = "";

		for (int i = (s.length() - 1); i >= 0; i--)
		{
			rev = rev + s.charAt(i);
		}

//		System.out.println("rev : "+rev);

		if (s.equals(rev))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not Palindrome");
		}

	}

	/**
	 * This code traverses only half length of String. Hence less iterations.
	 * 
	 * @param s
	 */
	public static void isStringPalindromeOptimized(String s)
	{
		int len = s.length();
		String fHalf = s.substring(0, len / 2);
		String sHalf = "";

		for (int i = (len - 1); i > len / 2; i--)
		{
			sHalf = sHalf + s.charAt(i);
		}

		System.out.println("fHalf : " + fHalf);
		System.out.println("sHalf : " + sHalf);

		if (fHalf.equals(sHalf) || fHalf.substring(0, (fHalf.length() - 1)).equals(sHalf))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not Palindrome");
		}

	}
	

	public static void main(String[] args)
	{
		System.out.println();
		System.out.println("******* printFactors*********");
		System.out.println();
		
		printFactors(38);
		
		System.out.println();
		System.out.println("******* printFactorsOptimized *********");
		System.out.println();
		
		printFactorsOptimized(38);

		System.out.println();
		System.out.println("******* isPrime *********");
		System.out.println();

		isPrime(37);

		System.out.println();
		System.out.println("******* reverseNum *********");
		System.out.println();

		reverseNum(1234);

		System.out.println();
		System.out.println("******* isPalindrome *********");
		System.out.println();

		isPalindrome(12321);

		System.out.println();
		System.out.println("******* isPalindromeOptimized *********");
		System.out.println();

		isPalindromeOptimized(12321);

		System.out.println();
		System.out.println("******* isStringPalindrome *********");
		System.out.println();

		isStringPalindrome("ABCBADWA");

		System.out.println();
		System.out.println("******* isStringPalindromeOptimized *********");
		System.out.println();

		isStringPalindromeOptimized("ABCDCBA");

	}

}
