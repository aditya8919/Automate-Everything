package pack1;


public class Client
{
	
	public static void main(String[] args)
	{
		C1 c = new C1();
		
		Thread t1 = new Thread(c);
		System.out.println("Thread Name : "+t1.getName());
		t1.start();
		
	}

}
