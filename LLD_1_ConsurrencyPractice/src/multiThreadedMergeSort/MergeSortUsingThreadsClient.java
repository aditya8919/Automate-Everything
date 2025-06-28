package multiThreadedMergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSortUsingThreadsClient
{

	public static void main(String[] args) throws InterruptedException, ExecutionException
	{

		List<Integer> list = List.of(6,5,8,9,7,4,1,2,3);
		ExecutorService es = Executors.newCachedThreadPool();
		
		MergeSortUsingThreads sortTask = new MergeSortUsingThreads(list, es);

	

		Future<List<Integer>> ans = es.submit(sortTask);

		List<Integer> sorted = ans.get();

		System.out.println(sorted);

	}

}
