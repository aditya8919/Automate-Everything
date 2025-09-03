package design_pattern_decorator;

import javax.management.RuntimeErrorException;

public class Milk extends Addons
{
	Beverage base;
	final int milkCost = 10;

	/**
	 * Parameterized Constructor makes sure that user cannot
	 * create just Addon, if user needs addon, he needs to have
	 * a base beverage.
	 * @param base
	 */
	public Milk(Beverage base)
	{
		if(base == null)
		{
			throw new RuntimeErrorException(null, "Base is null");
		}
		this.base = base;
	}

	int getCost()
	{
		System.out.println("Milk Cost : "+milkCost);
		
		return base.getCost() + milkCost - getComboDiscount();
	}


	String getDescription()
	{
		
		return "Milk Desc";
	}

	@Override
	int getComboDiscount()
	{
		System.out.println("getComboDiscount : Rs. "+5);
		return 5;
	}

}
