package synchronization_adder_subtracter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client
{

	public static void main(String[] args) throws InterruptedException, ExecutionException
	{

		Value x = new Value(0);

		ExecutorService executorService = Executors.newFixedThreadPool(2);

//	Below 2 lines will start/fire the taks
		Future<Integer> addFuture = executorService.submit(new Adder(x));
		Future<Integer> subFuture = executorService.submit(new Subtractor(x));

		
//	Below two lines will wait until 17 and 18 operations to be finished. 
		addFuture.get();
		subFuture.get();

		System.out.println("X is : " + x.getNum());

	}

}
