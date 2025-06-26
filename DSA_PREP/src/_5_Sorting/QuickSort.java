package _5_Sorting;

import _1_logicalProbs.ArraysProbs;

public class QuickSort
{

	/**
	 * Partitions the array around a pivot element.
	 * 
	 * The first element is chosen as the pivot. Elements greater than the pivot are
	 * moved to the endIndex, and elements less than or equal to the pivot are moved to
	 * the startIndex.
	 * 
	 * Time Complexity: O(n) where n is the length of the array. Space Complexity:
	 * O(1) since it sorts in place.
	 * 
	 * @param arr The array to be partitioned
	 * @return The index of the pivot element after partitioning
	 */
	public static int partition(int[] arr, int startIndex, int endIndex)
	{
		int pivote = arr[startIndex];
		int i = startIndex + 1; // Start from the second element
		int j = endIndex; // Start from the last element

		while (i <= j)
		{
			if (arr[i] > pivote)
			{
				ArraysProbs.swapEle(arr, i, j);

				j--;
			}
			else
			{
				i++;
			}

		}

// 			After the loop, all elements less than or equal to the pivot are on the startIndex
//			Only pivote ele is startIndex at the start of the array
//		 and all elements greater than the pivot are on the endIndex.
//		 Swap the pivot element with the last element of the startIndex partition
//		 to place it in its correct position.

		ArraysProbs.swapEle(arr, startIndex, j);

		return j; // Return the index of the pivot element

	}

	public static void quickSort(int[] arr, int startIndex, int endIndex)
	{
		if (startIndex >= endIndex)
		{
			return; // Base case: if the startIndex index is greater than the endIndex index, return
		}

		int pivotIndex = partition(arr, startIndex, endIndex);

		// Recursively sort the startIndex and endIndex partitions
		quickSort(arr, startIndex, (pivotIndex - 1));
		quickSort(arr, (pivotIndex + 1), endIndex);

	}
	
	public static void callQuickSort(int[] arr)
	{
		quickSort(arr, 0, arr.length - 1);
		
		for(int a : arr)
		{
			System.out.print(a + " ");
		}
	}

	public static void main(String[] args)
	{
		int[] A = { 10, 5, 7, 8, 20, 23, 25, 13 };

		int pi = partition(A, 0, A.length - 1);

		System.out.println("Pivot Index: " + pi);

		System.out.println();
		System.out.println("****** callQuickSort **********");
		System.out.println();

		callQuickSort(A);

	}

}
