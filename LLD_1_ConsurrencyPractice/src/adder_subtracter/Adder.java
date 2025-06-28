package adder_subtracter;

import java.util.concurrent.Callable;

public class Adder implements Callable<Integer>
{
	
	Value x;
	
	Adder(Value x)
	{
		this.x = x;
	}
	
	

	@Override
	public Integer call() throws Exception
	{
		for (int i = 1; i <= 100; i++)
		{
			x.setNum(x.getNum() + 1);
			System.out.println(x.getNum());
		}
		
		return x.getNum();
	}

}
