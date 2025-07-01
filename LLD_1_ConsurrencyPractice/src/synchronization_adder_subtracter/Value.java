package synchronization_adder_subtracter;

public class Value
{
	int num;
	
	public Value(int num)
	{
		this.num = num;
	}
	
	public synchronized  int getNum()
	{
		return num;
	}

	public synchronized  void setNum(int num)
	{
		this.num = num;
	}


	

}
