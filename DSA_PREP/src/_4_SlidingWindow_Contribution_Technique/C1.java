package _4_SlidingWindow_Contribution_Technique;

public class C1
{

	/**
	 * Brute force approach to find the sum of all subarrays.
	 * 
	 * @param arr
	 */
	public static void sumOfALlSubarrays(int[] arr)
	{
		int ans = 0;
		for (int left = 0; left < arr.length; left++)
		{
			int sum = 0;

			for (int right = 0; right < arr.length; right++)
			{

				for (int i = left; i <= right; i++)
				{
					sum += arr[i];
				}

			}
			ans += sum;
		}

		System.out.println(ans);
	}

	/**
	 * Optimized approach to find the sum of all subarrays.
	 * 
	 * This approach uses the fact that the sum of subarrays can be calculated
	 * incrementally, avoiding the need for nested loops using technique called
	 * "Carry Forward Technique".
	 * 
	 * @param arr
	 */
	public static void subarraySumOptimized(int[] arr)
	{
		int ans = 0;

		for (int i = 0; i < arr.length; i++)
		{
			int sum = 0;

			for (int j = i; j < arr.length; j++)
			{
				sum += arr[j];
				ans += sum;
			}
		}

		System.out.println(ans);
	}

	/**
	 * Optimized approach to find the sum of all subarrays.
	 * 
	 * This approach uses the fact that each element contributes to multiple
	 * subarrays, and we can calculate its contribution directly
	 * 
	 * Conttribution of ith element = arr[i] * (i + 1) * (n - i)
	 * 
	 * 
	 * 
	 * @param arr
	 */
	public static void sumOfALlSubarraysOptimized(int[] arr)
	{
		int ans = 0;

		for (int i = 0; i < arr.length; i++)
		{
			int contributionOfithEle = arr[i] * (i + 1) * (arr.length - i);
			ans += contributionOfithEle;
		}

		System.out.println(ans);
	}
	
	/**
	 * This method finds the maximum sum of a subarray of size K using an optimized
	 * sliding window technique with prefix sums.
	 * This approach uses a prefix sum array to calculate the sum of subarrays in
	 * O(1) time.
	 * 
	 * Space Complexity: O(n) for the prefix sum array.	
	 * Time Complexity: O(n) for calculating the prefix sum and O(n) for finding the
	 * maximum subarray sum, resulting in an overall time complexity of O(n).
	 * The prefix sum array allows us to compute the sum of any subarray in constant
	 * time, which is particularly useful for large arrays.
	 * 
	 * @param arr
	 * @param K
	 */
	public static void maxSubarraySum(int[] arr, int K )
	{
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for(int i = 0; i<K; i++)
		{
			sum += arr[i];

		}
		
		int [] pSum = new int[arr.length];
		pSum[0] = arr[0];
		
		for(int i = 1; i < arr.length; i++)
		{
			pSum[i] = pSum[i-1] + arr[i];
		}
		
		for(int L = 1; L <(arr.length - K) +1; L++)
		{
			int R = (L + K - 1);  // 6 - 3 +1 = 4   
			
//			sum = sum - arr[L-1] + arr[R];
			
				if(L == 0)
				{
					sum = pSum[R];
				}
				else
				{
					sum = pSum[R] - pSum[L-1];
				}
			
			System.out.println(sum);
			
			maxSum = Integer.max(maxSum, sum);
		}
		
		System.out.println("maxSum : " + maxSum);
	}


	/**
	 * This method finds the maximum sum of a subarray of size K using the sliding
	 * window technique.
	 * 
	 * Start Point of 1st subarray = 0
	 * End Point of 1st subarray = K - 1
	 * Start Point of last subarray = (arr.length - K)
	 * End Point of last subarray = arr.length - 1
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * sliding window technique can be used only when K is fixed, i.e., 
	 * the size of the subarray is constant.
	 * 
	 * @param arr The input array.
	 * @param K   The size of the subarray.
	 */
	public static void maxSubarraySumOptimized(int[] arr, int K )
	{
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for(int i = 0; i<K; i++)
		{
			sum += arr[i];

		}
		
		for(int L = 1; L <(arr.length - K) +1; L++)
		{
			int R = (L + K - 1);  // 6 - 3 +1 = 4   
			
			sum = sum - arr[L-1] + arr[R];
			
			System.out.println(sum);
			
			maxSum = Integer.max(maxSum, sum);
		}
		
		System.out.println("maxSum : " + maxSum);
	}
	
	
	

	public static void main(String[] args)
	{
		sumOfALlSubarrays(new int[]
		{ 3, 2, 5 });
		sumOfALlSubarraysOptimized(new int[]
		{ 3, 2, 5 });
		
		
		System.out.println();
		System.out.println("****** maxSubarraySum ******");
		System.out.println();
		
		int [] arr = { 3, -2,4, -1,2,6};
		
		maxSubarraySum(arr, 3);
		
		System.out.println();
		System.out.println("****** maxSubarraySumOptimized ******");
		System.out.println();
		
		maxSubarraySumOptimized(arr, 3);
		
	}

}
