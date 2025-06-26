package _8_Hashing_1;

import java.util.HashSet;

public class H1
{

  	/**
	 * This method checks if there is duplocate elements present in the given array.
	 * It uses a HashSet to track elements that have already been seen.
	 * If a duplicate is found, it prints the duplicate element and returns true.
	 * 
	 * @param arr The input array
	 * @return true if a subarray with sum zero is found, false otherwise
	 */
	public static boolean isDuplicateElePresentInArray(int[] arr)
	{
		boolean ans = false;
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i= 0; i <arr.length; i++)
		{
			if(set.contains(arr[i]))
			{
				System.out.println("Duplicate element found: " + arr[i]);
				ans = true;
			}
			
			set.add(arr[i]);
		}
		return ans;
	}
	
	
	/**
	 * This method checks if there is a subarray with sum zero in the given array.
	 * It uses prefix sum and a HashSet to find if any prefix sum has been seen before,
	 * indicating that the subarray between those two indices has a sum of zero.
	 * 
	 * @param arr The input array
	 * @return true if a subarray with sum zero is found, false otherwise
	 */
	public static boolean isSubArraySumZero(int []  arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == 0)
			{
				System.out.println("Subarray with sum zero found at index " + i);
				return true;
			}
		}
		
		
		int []  pSum = new int[arr.length];
		pSum[0] = arr[0];
		
		for(int i = 1; i < arr.length; i++)
		{
			pSum[i] = pSum[i - 1] + arr[i];
		}
		
		for(int i = 0; i < pSum.length; i++)
		{
			if(pSum[i] == 0)
			{
				System.out.println("Subarray with sum zero found at index " + i);
				return true;
			}
		}
		
		if(isDuplicateElePresentInArray(pSum) == true)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * This method finds pairs of elements in the array that sum up to a given value.
	 * It uses a HashSet to track elements and checks if the complement (sum - current element)
	 * exists in the set. If it does, it prints the pair and increments the count.
	 * 
	 * HashSet is used for O(1) average time complexity for searching; coz 
	 * searching is faster in HashSet than in ArrayList.
	 * 
	 * @param arr The input array
	 * @param sum The target sum for pairs
	 * @return The count of pairs found
	 */
	public static int pairSum(int [] arr, int sum)
	{
		int count = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i =0; i<arr.length; i++)
		{
			if(set.contains(sum - arr[i]))
			{
				System.out.println("Pair found: " + arr[i] + ", " + (sum - arr[i]));
				count++;
			}
			
			set.add(arr[i]);
		}
		
		return count;

	}

	
	public static void main(String[] args)
	{
		System.out.println("****** isSubArraySumZero ******");
		System.out.println();
		
		boolean ans = isSubArraySumZero(new int[] {1, 2, -3, 4, 5});
		
		System.out.println(ans);
		
		System.out.println();
		System.out.println("******* isDuplicateElePresentInArray *******");
		System.out.println();
		
		int [] duplicate = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 };
		
		boolean ans3 = isDuplicateElePresentInArray(duplicate);
		System.out.println(ans3);

		
		System.out.println();
		System.out.println("****** pairSum ******");
		System.out.println();
		
		int count = pairSum(new int[] {1, 2, 3, 4, 5, 6}, 7);
		System.out.println("Total pairs with sum 7: " + count);
	}
}
