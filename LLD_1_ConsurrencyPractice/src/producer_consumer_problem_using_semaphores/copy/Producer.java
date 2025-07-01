package producer_consumer_problem_using_semaphores.copy;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable
{
	Store store;
	Semaphore prodSemaphore;
	Semaphore consSemaphore;

	public Producer(Store store, Semaphore prodSemaphore,Semaphore consSemaphore)
	{
		this.store = store;
		this.prodSemaphore = prodSemaphore;
		this.consSemaphore = consSemaphore;
	}

	@Override
	public void run()
	{

		while (true)
		{
			try
			{
				prodSemaphore.acquire();
				
				if (store.getItems().size() < store.maxSize)
				{
					String newItem = new String("New_Item");
					store.addItem(new String("New_Item"));
					System.out.println("Added item : " + newItem);
				}
				
				consSemaphore.release();
				
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
	}

}
