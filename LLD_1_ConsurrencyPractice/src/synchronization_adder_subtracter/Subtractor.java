package synchronization_adder_subtracter;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Integer>
{
	Value x;
	
	Subtractor(Value x)
	{
		this.x = x;
	}
	
	

	@Override
	public Integer call() throws Exception
	{
		for (int i = 1; i <= 100000; i++)
		{
			synchronized (x)
			{
				x.setNum(x.getNum() -1);
//			System.out.println(x.getNum());
			}

		}
		return x.getNum();
	}
}
