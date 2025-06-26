package _1_logicalProbs;

import java.util.HashMap;
import java.util.HashSet;

public class ArraysProbs
{

	/**
	 * Compare each ele of array with smallest possible number
	 * 
	 * @param arr
	 */
	public static int findLargestEle(int[] arr)
	{
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] > max)
			{
				max = arr[i];
			}
		}

		System.out.println("max ele : " + max);
		
		return max;
	}

	/**
	 * Compare each ele of array with largest possible number
	 * 
	 * @param arr
	 */
	public static int findSmallestEle(int[] arr)
	{
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] < min)
			{
				min = arr[i];
			}
		}

		System.out.println("min ele : " + min);
		
		return min;
	}

//more optimized way to find smallest and largest ele is
//sort the array and return last ele for largest and 1st ele for smallest
//This way, TC will be reduced to O(log n)
//For previous approach, TC = O(n)  --> linear approach

	public static int getFrequency(int[] arr, int num)
	{
		int freq = 0;

		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] == num)
			{
				freq++;
			}
		}

		System.out.println(freq);

		return freq;
	}

	/**
	 * Bruteforce approach to find out frequency array
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] getFrequencyArray(int[] arr)
	{
		int[] freqArr = new int[arr.length];

		for (int i = 0; i < arr.length; i++)
		{
			freqArr[i] = getFrequency(arr, arr[i]);
		}

		return freqArr;
	}

	public static void getFreqArrayOptimized(int[] arr, int sum)
	{
		HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++)
		{
			freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
		}

		System.out.println(freqMap);
	}

	/**
	 * Brute force ans
	 * 
	 * Find count of pairs having sum = given sum
	 * 
	 * @param arr
	 * @param sum
	 * @return
	 */
	public static int getPairSumCount(int[] arr, int sum)
	{
		int ans = 0;

		for (int i = 0; i < arr.length; i++)
		{
			for (int j = i + 1; j < arr.length; j++)
			{
				if (arr[i] + arr[j] == sum)
				{

					System.out.println(arr[i] + " + " + arr[j]);

					ans++;
				}
			}
		}

		System.out.println("Total Pairs : " + ans);

		return ans;
	}

	public static int[] reverseArray(int[] arr)
	{
		int i = 0;
		int j = arr.length - 1;

		while (i < j)
		{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

			i++;
			j--;
		}

		return arr;
	}

	public static int[] reversePartArray(int[] arr, int left, int right)
	{
		int i = left;
		int j = right;

		while (i < j)
		{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

			i++;
			j--;
		}

		return arr;
	}
	

	public static int [] swapEle(int [] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		return arr;
	}



	public static void main(String[] args)
	{
		int[] arr =
		{ 8, 4, 3, 15, 7, 6, 2, 2, 6, 3, 7, 3, 5, 9, 3 };

		findLargestEle(arr);

		System.out.println();
		System.out.println("******* findSmallestEle *******");
		System.out.println();

		findSmallestEle(arr);

		System.out.println();
		System.out.println("******* getFrequency *******");
		System.out.println();

		getFrequency(arr, 3);

		System.out.println();
		System.out.println("******* getFrequencyArray *******");
		System.out.println();

		int[] arr2 = getFrequencyArray(arr);

		System.out.println();
		System.out.println("ans");
		System.out.println();

		System.out.println();
		System.out.println("******* getFreqArrayOptimized *******");
		System.out.println();

		getFreqArrayOptimized(arr, 8);

		for (int a : arr2)
		{
			System.out.println(a);
		}

		System.out.println();
		System.out.println("******* getPairSumCount *******");
		System.out.println();

		getPairSumCount(arr, 8);

		System.out.println();
		System.out.println("******* reverseArray *******");
		System.out.println();

		int[] rev =
		{ 1, 2, 3, 4, 5, 6 };
		int[] ans = reverseArray(rev);

		for (int a : ans)
		{
			System.out.print(a + " ");
		}

		System.out.println();
		System.out.println("******* reverseArray *******");
		System.out.println();

		int[] rev2 = { 1, 2, 3, 4, 5, 6,7,8,9 };
		int[] ans2 = reversePartArray(rev2,2,7);

		for (int a : ans2)
		{
			System.out.print(a + " ");
		}
		

	}

}
