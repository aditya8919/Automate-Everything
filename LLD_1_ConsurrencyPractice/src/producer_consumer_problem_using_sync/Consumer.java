package producer_consumer_problem_using_sync;

public class Consumer implements Runnable
{
	
	Store store;
	
	public Consumer(Store store)
	{
		this.store = store;
	}

	@Override
	public void run()
	{
		
		while(true)
		{
//		here we are allowing only 1 person/thread at a time inside store.
//		Other people/threads will wait until entered thread finishes its work
			synchronized (store)
			{
				if(store.getItems().size() > 0)
				{
					store.removeItem();
					System.out.println("Removed Item.");
				}
			}

			
		}

	}
	
	

}
