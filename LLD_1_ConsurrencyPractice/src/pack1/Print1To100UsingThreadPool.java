package pack1;

public class Print1To100UsingThreadPool implements Runnable
{
	int num = 1;
	
	Print1To100UsingThreadPool(int num)
	{
		this.num = num;
	}

	@Override
	public void run()
	{

			System.out.println(num);
			
			if(num == 40)
			{
				System.out.println("DEBUG");
			}
	}

}
