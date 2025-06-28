package pack1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableLearningClient
{

	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		ExecutorService es = Executors.newCachedThreadPool();

		CallableLearning task1 = new CallableLearning(2);

		Future<Integer> futureResult = es.submit(task1);

		Integer result = futureResult.get();
		
		System.out.println(result);

	}

}
