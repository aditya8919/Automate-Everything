package producer_consumer_problem_using_semaphores.copy;

import java.util.concurrent.Semaphore;

public class Client
{

	public static void main(String[] args)
	{
		Store store1 = new Store(30);
		Semaphore prodSemaphore = new Semaphore(8);
		Semaphore consSemaphore = new Semaphore(20);

		
		for(int i = 1; i<= 8; i++)
		{
			new Thread(new Producer(store1,prodSemaphore, consSemaphore)).start();
		}
		
		
		for(int i = 1; i<= 20; i++)
		{
			new Thread(new Consumer(store1,prodSemaphore, consSemaphore)).start();
		}

//		Thread prodThread = new Thread(p1);
//		Thread consThread = new Thread(c1);
		
//		prodThread.start();
//		consThread.start();

	}

}
