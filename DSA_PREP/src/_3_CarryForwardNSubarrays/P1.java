package _3_CarryForwardNSubarrays;

import _1_logicalProbs.ArraysProbs;

public class P1
{
	
	/**
	 * This method counts the number of pairs of 'a' and 'g' in the given string
	 * such that 'a' comes before 'g'.
	 * 
	 * Solution approach:
	 * 1. Initialize two counters: one for 'a' and another for pairs of 'a' and 'g'.
	 * 2. Traverse the string character by character.
	 * 3. For each 'a' encountered, increment the 'a' counter.
	 * 4. For each 'g' encountered, add the current count of 'a' to the pairs counter.
	 * * Time Complexity: O(n), where n is the length of the string.
	 * * Space Complexity: O(1), as we are using a constant amount of extra space.
	 * * @note This method assumes that the input string contains only lowercase letters.
	 * 
	 * @param s The input string
	 */
	public static void agPairs(String s)
	{
		int aCount = 0;
		int agCount = 0;
		
		for(int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == 'a')
			{
				aCount++;
			}
			else if (s.charAt(i) == 'g')
			{
				agCount += aCount;
			}
		}
		
		System.out.println(agCount);
		
	}

	
	/**
	 * This method finds the smallest subarray length that contains both the largest and 
	 * smallest elements of the given array.
	 * 
	 * Solution approach:
	 * 1. Find the largest and smallest elements in the array.
	 * 2. Traverse the array to find the latest indices of the largest and smallest elements.
	 * 3. Calculate the length of the subarray between these indices whenever both elements are found.
	 * 4. Keep track of the minimum length found.
	 * * Time Complexity: O(n)
	 * * Space Complexity: O(1)
	 * * @note This method assumes that the array contains at least one element.
	 * @param arr
	 */
	public static void smallestNLargestInSubarry(int [] arr)
	{
		
		int largest = ArraysProbs.findLargestEle(arr);
		int smallest = ArraysProbs.findSmallestEle(arr);
		int latestMaxIndex = -1;
		int latestMinIndex = -1;
		int ans = Integer.MAX_VALUE;
		int length = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			if (arr[i] == largest)
			{
				latestMaxIndex = i;
				
				if (latestMinIndex != -1)
				{
					length = (latestMaxIndex - latestMinIndex) + 1;
					
					System.out.println("length : " + length);
					
					ans = 	Integer.min(ans, length);
				}
			}
			
			if (arr[i] == smallest)
			{
				latestMinIndex = i;
				
				if (latestMaxIndex != -1)
				{
					length = (latestMinIndex - latestMaxIndex) + 1;
					
					System.out.println("length : " + length);
					
					ans = 	Integer.min(ans, length);
				}
			}
		}
		
		System.out.println("ans : "+ans);
		
		
	}
	

	
	public static void main(String[] args)
	{
		agPairs("bcaggaag");
		
		System.out.println();
		System.out.println("***** smallestNLargestInSubarry *****");
		System.out.println();
		
		
		smallestNLargestInSubarry(new int[] {2,2,6,4,5,1,5,2,6,4,1});
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
