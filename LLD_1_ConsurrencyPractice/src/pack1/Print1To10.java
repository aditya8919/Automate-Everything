package pack1;

public class Print1To10 implements Runnable
{
	int num = 1;

	Print1To10(int num)
	{
		this.num = num;
	}

	@Override
	public void run()
	{

		System.out.println(num);

	}

}
