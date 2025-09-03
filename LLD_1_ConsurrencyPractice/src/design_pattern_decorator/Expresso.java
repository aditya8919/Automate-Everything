package design_pattern_decorator;

public class Expresso extends Beverage
{

	/**
	 * Non-param constructor allows Beverage to be created
	 * without addon.
	 */
	public Expresso()
	{
		
	}

	int getCost()
	{
		System.out.println("Expresso Cost : "+50);
		return 50;
	}


	String getDescription()
	{
		System.out.println("Expresso Desc");
		return null;
	}

}
