package pack1;

import java.util.concurrent.Callable;

public class CallableLearning implements Callable<Integer>
{

	int num;
	
	public int getNum()
	{
		return num;
	}


	public void setNum(int num)
	{
		this.num = num;
	}


	public CallableLearning(int num)
	{
		super();
		this.num = num;
	}

	@Override
	public Integer call() throws Exception
	{
		
		num = num * 10;
//		System.out.println(num);
		
		return num;
	}

}
