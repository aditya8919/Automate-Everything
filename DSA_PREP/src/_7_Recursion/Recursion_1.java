package _7_Recursion;

public class Recursion_1
{

	public static int getFactorial(int num)
	{
		if(num <= 1)
		{
			return 1;
		}
		
		
		int ans = getFactorial(num - 1);
		
		return ans * num;
	}
	
	public static void printNumsFrom1(int num)
	{
		if(num <= 1)
		{
			System.out.println(num);
			return;
		}
		
		printNumsFrom1(num - 1);
		
		System.out.println(num);
	}
	
	public static int getFiboncaci(int num)
	{
		if(num <= 1)
		{
			return num;
		}
		
		int ans = getFiboncaci(num -1) + getFiboncaci(num - 2);
		
		return ans;
	}
	

	
	public static void main(String[] args)
	{
		int ans = getFactorial(5);
		
		System.out.println(ans);
		
		System.out.println();
		System.out.println("**** printNumsFrom1 ******");
		System.out.println();
		
		printNumsFrom1(5);
		
		System.out.println();
		System.out.println("**** getFiboncaci ******");
		System.out.println();
		
		 int fib = getFiboncaci(7);
		 
		 System.out.println(fib);
		 

		 
		 
	}
}
