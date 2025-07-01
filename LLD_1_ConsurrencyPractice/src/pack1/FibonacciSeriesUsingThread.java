package pack1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// do later

public class FibonacciSeriesUsingThread implements Callable<Integer>
{
	int num = 0;

	public FibonacciSeriesUsingThread(int num)
	{

		this.num = num;

	}

	/*
	 * method to get fibnacci num without threads
	 */
	public static int getFib(int num)
	{
		if (num == 0)
		{
			return 1;
		}
		else if (num == 1)
		{
			return 1;
		}
		return getFib(num - 1) + getFib(num - 2);
	}

	public static Integer getFibUsingThread(Integer num)
	{
		if (num == 0)
		{
			return 1;
		}
		else if (num == 1)
		{
			return 1;
		}
		return getFib(num - 1) + getFib(num - 2);
	}

	public static void main(String[] args)
	{
		System.out.println(getFib(3));
	}

	@Override
	public Integer call() throws Exception
	{

		if(num == 0)
		{
			return 0;
		}
		else if(num == 1)
		{
			return 1;
		}

		ExecutorService es = Executors.newCachedThreadPool();

		FibonacciSeriesUsingThread ans1 = new FibonacciSeriesUsingThread(num - 1);
		FibonacciSeriesUsingThread ans2 = new FibonacciSeriesUsingThread(num - 2);

		
//		 below 2 lines will be executed paralley
		Future<Integer> fib1 = es.submit(ans1);
		Future<Integer> fib2 = es.submit(ans2);

		return fib1.get() + fib2.get();
	}

}
