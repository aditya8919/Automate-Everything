package pack1;

public class C1 implements Runnable
{

	public void printData()
	{
		System.out.println("printData method");
	}
	
	@Override
	public void run()
	{
		
		printData();
	}
	
	

}
