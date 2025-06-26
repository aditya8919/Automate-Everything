package _2_arraysPrefixSum;

public class P1
{

	// 10,20,30,40,50

	/**
	 * This method creates a prefix sum array from the given array A.
	 * 
	 * @param A The input array for which the prefix sum is calculated.
	 * @return An array containing the prefix sums of the input array.
	 */
	public static int[] createPSumArray(int[] A)
	{
		int[] pSum = new int[A.length];

		pSum[0] = A[0];

		for (int i = 1; i < A.length; i++)
		{
			pSum[i] = pSum[i - 1] + A[i];
		}

		return pSum;
	}

	/**
	 * This method calculates the range sum for given queries using a prefix sum
	 * array.
	 * 
	 * @param arr     The input array for which the prefix sum is calculated.
	 * @param queries An array of queries where each query contains two indices
	 *                [left, right].
	 * @return An array containing the sum of elements from index left to right for
	 *         each query.
	 */
	public static int[] createPSumArrayEvenIndex(int[] A)
	{
		int[] psumEven = new int[A.length];

		psumEven[0] = A[0];

		for (int i = 1; i < A.length; i++)
		{
			if (i % 2 != 0)
			{
				psumEven[i] = psumEven[i - 1];
			}
			else
			{
				psumEven[i] = psumEven[i - 1] + A[i];
			}

		}

		return psumEven;
	}

	/**
	 * This method calculates the sum of elements in the given array for each query.
	 * 
	 * @param arr     The input array.
	 * @param queries An array of queries, where each query is an array of two
	 *                integers representing the left and right indices.
	 * @return An array containing the sum of elements for each query.
	 */
	public static int[] rangeSum(int[] arr, int[][] queries)
	{
		int[] pSum = createPSumArray(arr);
		int[] ans = new int[queries.length];

		for (int i = 0; i < queries.length - 1; i++)
		{
			int left = queries[i][0];
			int right = queries[i][1];

			if (left == 0)
			{
				ans[i] = pSum[right];
			}
			else
			{
				ans[i] = pSum[right] - pSum[left - 1];
			}

		}

		return ans;
	}

	/**
	 * This method calculates the sum of elements at even indices in the given array
	 * for each query.
	 * 
	 * @param arr     The input array.
	 * @param queries An array of queries, where each query is an array of two
	 *                integers representing the left and right indices.
	 * @return An array containing the sum of elements at even indices for each
	 *         query.
	 */
	public static int[] rangeSumEvenIndex(int[] arr, int[][] queries)
	{
		int[] pSumEven = createPSumArrayEvenIndex(arr);
		int[] ans = new int[queries.length];

		for (int i = 0; i < queries.length - 1; i++)
		{
			int left = queries[i][0];
			int right = queries[i][1];

			if (left == 0)
			{
				ans[i] = pSumEven[right];
			}
			else
			{
				ans[i] = pSumEven[right] - pSumEven[left - 1];
			}

		}

		return ans;
	}

	public static void specialIndex(int[] A)
	{
		int size = A.length;
		int currIndex = 0;
		int sumEven = 0;
		int sumOdd = 0;

		for (int idx = currIndex; idx < size; idx++)
		{
			for (int i = 0; i < currIndex; i++)
			{
				if (i % 2 == 0)
				{
					sumEven += A[i];
				}
				else
				{
					sumOdd += A[i];
				}
			}

			for (int i = currIndex + 1; i < size; i++)
			{
				if (i % 2 == 0)
				{
					sumOdd = sumEven + A[i];
				}
				else
				{
					sumEven += sumOdd + A[i];
				}
			}
			
			System.out.println("sumEven : " + sumEven);
			System.out.println("sumOdd : " + sumOdd);
			System.out.println();
			sumEven = 0;
			sumOdd = 0;
		}
		


	}

	public static void main(String[] args)
	{
		System.out.println();
		System.out.println("******* createPSumArray *******");
		System.out.println();

		int[] A =
		{ 10, 4, 7, 14, 16, 11 };

		int[] ansPsumArr = createPSumArray(A);

		for (int a : ansPsumArr)
		{
			System.out.print(a + " ");
		}

		System.out.println();
		System.out.println("******* rangeSum *******");
		System.out.println();

		int[] A2 =
		{ 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int[][] queries =
		{

				{ 2, 5 },
				{ 0, 4 },
				{ 3, 5 },
				{ 3, 7 },
				{ 2, 8 },
				{ 4, 9 } };

		int[] rangeArr = rangeSum(A2, queries);

		for (int a : rangeArr)
		{
			System.out.print(a + " ");
		}

		System.out.println();
		System.out.println("******* createPSumArrayEvenIndex *******");
		System.out.println();

		int[] ansPsumEven = createPSumArrayEvenIndex(A);

		for (int a : ansPsumEven)
		{
			System.out.print(a + " ");
		}

		System.out.println();
		System.out.println("******* rangeSumEvenIndex *******");
		System.out.println();

		int[] ans3 = rangeSumEvenIndex(A2, queries);

		for (int a : ans3)
		{
			System.out.print(a + " ");
		}

		System.out.println();
		System.out.println("******* specialIndex *******");
		System.out.println();

		int[] spclIndex =
		{ 4, 3, 2, 7, 6, -2 };
		specialIndex(spclIndex);
	}

}
