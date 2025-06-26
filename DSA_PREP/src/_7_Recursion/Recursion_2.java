package _7_Recursion;

public class Recursion_2
{
	/**
	 * This method calculates a raised to the power m using recursion.
	 * 
	 * Time Complexity: O(m) Space Complexity: O(m) due to recursive stack space.
	 * 
	 * @param a base
	 * @param m exponent
	 * @return a raised to the power m
	 */
	public static int getPower(int a, int m)
	{
		if (m == 1)
		{
			return a;
		}
		else if (m == 0)
		{
			return 1;
		}
		else if (a == 1)
		{
			return 1;
		}

		int ans = getPower(a, m - 1);

		return ans * a;
	}

	/**
	 * Optimized version of getPower method. This method uses the property that a^m
	 * = (a^(m/2))^2 if m is even and a^m = (a^(m/2))^2 * a if m is odd.
	 * 
	 * Time Complexity: O(log m) Space Complexity: O(log m) due to recursive stack
	 * space.
	 * 
	 * @param a base
	 * @param m exponent
	 * @return a raised to the power m
	 */
	public static int getPowerOptimized(int a, int m)
	{
		if (m == 1)
		{
			return a;
		}
		else if (m == 0)
		{
			return 1;
		}
		else if (a == 1)
		{
			return 1;
		}

		int ans = getPowerOptimized(a, m / 2);

		if (m % 2 == 0)
		{
			return ans * ans;
		}
		else
		{
			return ans * ans * a;
		}
	}

	/**
	 * This method prints the elements of an array in reverse order using recursion.
	 * 
	 * @param arr        the array to be printed
	 * @param startIndex the index from which to start printing
	 */
	public static void printArray(int[] arr, int startIndex)
	{
		if (startIndex == arr.length)
		{
			return;
		}

		printArray(arr, startIndex + 1);

		System.out.println(arr[startIndex]);
	}
	
	
	public static int getMaxEleInArray(int[] arr, int startIndex)
	{
		if (startIndex == arr.length - 1)
		{
			return arr[arr.length - 1];
		}
		
		
		int ans  = getMaxEleInArray(arr, startIndex + 1);
		
		if(ans > arr[startIndex])
		{
			return ans;
		}
		else
		{
			return arr[startIndex];
		}
	}
	
	
	public static int[] getDuplicateEleIndices(int [] arr, int startIndex, int ele)
	{
		
		if(startIndex == arr.length)
		{
			return new int[0];
		}
		
		 int[] ans = getDuplicateEleIndices(arr,startIndex + 1, ele);
		 
		 if(arr[startIndex] == ele)
		 {
			 int [] newAns = new int[ans.length + 1];
			 newAns[0] = startIndex;
			 
			 // copying elements from ans to newAns
			 for(int i = 0; i < ans.length; i++)  
			 {
				 newAns[i + 1] = ans[i];
			 }

			 
			 return newAns;
		 }
		 else
		 {
			 return ans;
		 }
		
	}


	public static void main(String[] args)
	{
		System.out.println();
		System.out.println("**** getPower ******");
		System.out.println();

		int power = getPower(25, 3);

		System.out.println(power);

		System.out.println();
		System.out.println("**** getPowerOptimized ******");
		System.out.println();

		int power2 = getPowerOptimized(25, 3);

		System.out.println(power2);
		
		System.out.println();
		System.out.println("**** getPowerOptimized ******");
		System.out.println();
		
		int [] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		printArray(arr, 0);
		
		
		System.out.println();
		System.out.println("**** getMaxEleInArray ******");
		System.out.println();
		
		int [] arr2 = { 13, 25, 32, 46, 45, 36,17, 8, 59 };
		
		
		int maxEle = getMaxEleInArray(arr2, 0);
		System.out.println("Max Element in Array : " + maxEle);
		
		System.out.println();
		System.out.println("**** getDuplicateEleIndices ******");
		System.out.println();
		
		int [] arr3 = { 3,5,6,4,2,7,3,8,3 };
		
		 int[] ans = getDuplicateEleIndices(arr3, 0, 3);
		 
		 for(int a : ans)
		 {
			 System.out.print(a + " ");
		 }

		
	}

}
