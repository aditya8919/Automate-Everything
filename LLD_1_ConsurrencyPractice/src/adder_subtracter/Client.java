package adder_subtracter;

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

		Future<Integer> addFuture = executorService.submit(new Adder(x));

		Future<Integer> subFuture = executorService.submit(new Subtractor(x));

		addFuture.get();
		subFuture.get();

		System.out.println("X is : " + x.getNum());

	}

}
