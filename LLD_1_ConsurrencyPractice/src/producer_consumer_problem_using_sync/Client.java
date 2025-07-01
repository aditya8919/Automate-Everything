package producer_consumer_problem_using_sync;

public class Client
{

	public static void main(String[] args)
	{
		Store store1 = new Store(30);

//		Producer p1 = new Producer(store1);
//		Consumer c1 = new Consumer(store1);
		
		for(int i = 1; i<= 8; i++)
		{
			new Thread(new Producer(store1)).start();
		}
		
		
		for(int i = 1; i<= 20; i++)
		{
			new Thread(new Consumer(store1)).start();
		}

//		Thread prodThread = new Thread(p1);
//		Thread consThread = new Thread(c1);
		
//		prodThread.start();
//		consThread.start();

	}

}
