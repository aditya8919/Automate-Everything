package pack1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Print1To100UsingThreadPoolClient
{

	public static void main(String[] args)
	{

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		

		
		for (int i = 1; i <= 100; i++)
		{
			executorService.execute(new Print1To100UsingThreadPool(i));
			
//			System.out.println("Thread : " + executorService.na);
		}
		
		
	}

}
