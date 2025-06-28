package multiThreadedMergeSort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort
{
	/**
	 * Merges two sorted arrays into one sorted array.
	 * 
	 * It uses two pointers to traverse both arrays and compare their elements, adding the smaller element to the result array.
	 * After one of the arrays is fully traversed, it appends the remaining elements of the other array to the result.	
	 * Time Complexity: O(n + m) where n is the length of A and m is the length of B.
	 * Space Complexity: O(n + m) for the result array.
	 * 
	 * @note This method assumes that both input arrays are already sorted in ascending order.
	 * @param A First sorted array
	 * @param B Second sorted array
	 * @return Merged sorted array containing elements from both A and B
	 */
	public static List<Integer> merge2SortedArrays(List<Integer> A, List<Integer> B)
	{
		List<Integer> ans =  new ArrayList<Integer>();
		
		int p1 = 0; // pointer for A
		int p2 = 0; // pointer for B
		int i = 0;
		

			while(p1 < A.size() && p2 < B.size())
			{
				if(A.get(p1) < B.get(p2))
				{
					ans.add(A.get(p1));
					p1++;
					i++;
				}
				else
				{
					ans.add(B.get(p2));
					p2++;
					i++;
				}
			}
			
			while(p1 < A.size())
			{
				ans.add(A.get(p1));
				p1++;
				i++;
			}
			
			while(p2 < B.size())
			{
				ans.add(B.get(p2));
				p2++;
				i++;
			}
			
			return ans;
	}
	
	/**
	 * Merge sort algorithm implementation.
	 * This method recursively divides the array into halves until it reaches a base case of a single element,
	 * then merges the sorted halves back together.
	 * Time Complexity: O(n log n) where n is the number of elements in the array.
	 * Space Complexity: O(n) for the temporary arrays used during merging.
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
//	public static int [] mergeSort(int [] arr, int start, int end)
//	{
//		if(start >= end)
//		{
//			return new int[] {arr[start]};
//		}
//		
//		int mid = (start + end) / 2;
//		
//		int [] a1 = mergeSort(arr, start, mid);
//		int [] a2 = mergeSort(arr, mid + 1, end);
//		
//		int [] ans = merge2SortedArrays(a1, a2);
//		
//		return ans;
//	}
	
	
	
//	public static void main(String[] args)
//	{
//		int [] A = {1, 3, 5, 7,10, 12, 14, 16};
//		int [] B = {2, 4, 6, 8};
//		
//		
//		int [] ans  = merge2SortedArrays(A, B);
//		
//		for(int a : ans)
//		{
//			System.out.print(a + " ");
//		}
//		
//		System.out.println();
//		System.out.println("***** mergeSort *****");
//		System.out.println();
//		
//		
//		int [] arr = {3, 8, 2, -1, 5, -3};
//		int [] sortedArr = mergeSort(arr, 0, arr.length - 1);
//		for(int a : sortedArr)
//		{
//			System.out.print(a + " ");
//		}
//	}
	
	

}
