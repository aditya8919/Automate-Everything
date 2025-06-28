package multiThreadedMergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSortUsingThreads implements Callable<List<Integer>>
{

	List<Integer> arrListToSort;
	ExecutorService threadPool;

	MergeSortUsingThreads(List<Integer> arrListToSort, ExecutorService threadPool)
	{
		this.arrListToSort = arrListToSort;
		this.threadPool = threadPool;
	}

	
	/**
	 * Here we are just recursively calling the function using thread/submit() method from client class
	 * Thread wil not change the algorithm, hence no impact on Time Complexity. 
	 */
	@Override
	public List<Integer> call() throws Exception
	{

		if (arrListToSort.size() == 1)
		{
			return arrListToSort;
		}

		int size = arrListToSort.size();
		int mid = size / 2;

		List<Integer> leftArr = new ArrayList<Integer>();
		List<Integer> rightArr = new ArrayList<Integer>();

		for (int i = 0; i < mid; i++)
		{
			leftArr.add(arrListToSort.get(i));
		}

		for (int i = mid; i < size; i++)
		{
			rightArr.add(arrListToSort.get(i));
		}

		
//		If we write below line here, it will create multiple pools, hence we 
//		are now getting the pool from constructor
//		ExecutorService es = Executors.newCachedThreadPool();

		MergeSortUsingThreads leftSorterTask = new MergeSortUsingThreads(leftArr, threadPool);
		MergeSortUsingThreads rightSorterTask = new MergeSortUsingThreads(rightArr, threadPool);

		
//	Here, if 57 line takes 30 seconds and 58 as well, then without threads we would have waited
//	60 seconds; but using threads, below 2 lines will be started at the same time
//	hence we need to wait only for 30 sec to get the final ans.. 
		Future<List<Integer>> futureLeftSortedArr = threadPool.submit(leftSorterTask);
		Future<List<Integer>> futureRightSortedArr = threadPool.submit(rightSorterTask);

		List<Integer> sortedLeft = futureLeftSortedArr.get();
		List<Integer> sortedRight = futureRightSortedArr.get();
		
		
		
		// merge the 2 sorted arrays using merge2SortedArrays method
		
		List<Integer> sortedArray = MergeSort.merge2SortedArrays(sortedLeft, sortedRight);
		

		return sortedArray;
	}

}
