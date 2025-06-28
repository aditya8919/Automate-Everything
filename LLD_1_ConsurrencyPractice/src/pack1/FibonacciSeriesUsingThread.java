package pack1;

import java.util.concurrent.Callable;


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
		if(num == 0)
		{
			return 1;
		}
		else if(num == 1)
		{
			return 1;
		}
		return getFib(num - 1) + getFib(num - 2);
	}
	
	
	public static Integer getFibUsingThread(Integer num)
	{
		if(num == 0)
		{
			return 1;
		}
		else if(num == 1)
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

		
		int ans1 = getFibUsingThread(num -1);
		int ans2 = getFibUsingThread(num -1);
		
		
		return ans2;
		
		
		
		
	}

}
