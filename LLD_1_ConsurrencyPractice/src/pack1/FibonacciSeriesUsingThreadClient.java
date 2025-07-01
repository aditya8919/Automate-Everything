package pack1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciSeriesUsingThreadClient
{

	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		
//		0,1,1,2,3,5,8,13,21
		
		int num = 7;

		ExecutorService es = Executors.newCachedThreadPool();

		FibonacciSeriesUsingThread task = new FibonacciSeriesUsingThread(num);		
		 Future<Integer> fibFuture = es.submit(task);
		 
		  Integer fib = fibFuture.get();
		 
		 System.out.println("Fibonacci of "+num+" is : " + fib);
		
		
	}
}
