package producer_consumer_problem_using_semaphores.copy;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable
{

	Store store;
	Semaphore prodSemaphore;
	Semaphore consSemaphore;

	public Consumer(Store store, Semaphore prodSemaphore, Semaphore consSemaphore)
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
				consSemaphore.acquire();

				if (store.getItems().size() > 0)
				{
					store.removeItem();
					System.out.println("Removed Item.");
				}

				prodSemaphore.release();
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
