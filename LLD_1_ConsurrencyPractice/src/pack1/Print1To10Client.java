package pack1;

public class Print1To10Client
{

	public static void main(String[] args)
	{
		
		for(int i = 1; i <= 10; i++)
		{
			Thread t = new Thread(new Print1To10(i));
			t.start();  // call Run function
			
//			System.out.println("Thread Name : "+ t.getName());
		}
		
		
		
		
	}
}
