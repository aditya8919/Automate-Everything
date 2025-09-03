package design_pattern_decorator;

import javax.management.RuntimeErrorException;

public class Cream extends Addons
{
	Beverage base;
	final int creamCost = 10;

	public Cream(Beverage base)
	{
		this.base = base;
	}

	int getCost()
	{
		System.out.println("Cream Cost : "+creamCost);
		if(base == null)
		{
			throw new RuntimeErrorException(null, "Base is null");
		}
		return base.getCost() + creamCost - getComboDiscount();
	}


	String getDescription()
	{
		
		return "Cream Desc";
	}

	@Override
	int getComboDiscount()
	{
		System.out.println("getComboDiscount : Rs. "+10);
		return 0;
	}

}
