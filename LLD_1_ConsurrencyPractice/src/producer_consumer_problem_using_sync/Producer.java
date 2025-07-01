package producer_consumer_problem_using_sync;

public class Producer implements Runnable
{
	Store store;
	
	public Producer(Store store)
	{
		this.store = store;
		
	}

	@Override
	public void run()
	{
		
		while(true)
		{
//			here we are allowing only 1 person/thread at a time inside store.
//			Other people/threads will wait until entered thread finishes its work
			synchronized (store)
			{
				if (store.getItems().size() < store.maxSize)
				{
					String newItem = new String("New_Item");
					store.addItem(new String("New_Item"));
					System.out.println("Added item : "+newItem);
				} 
			}
		}
	}
	
	
	
	

}
