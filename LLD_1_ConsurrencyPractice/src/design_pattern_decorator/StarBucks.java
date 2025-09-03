package design_pattern_decorator;

public class StarBucks
{
	
	public static void main(String[] args)
	{
		
		Beverage expresso = new Expresso();
		Beverage milkExpresso = new Milk(expresso);
		Beverage creamMilkExpresso = new Cream(milkExpresso);
		
		 int price = creamMilkExpresso.getCost();
		 System.out.println(price);
		 
		 System.out.println();
		 System.out.println("********* 2nd way **********");
		 System.out.println();
		 
		 
		 Beverage b = new Milk(new Cream(new Expresso()));
		 
		 int cost = b.getCost();
		 System.out.println("Total Cost : "+cost);
		 
		 
		 System.out.println();
		 System.out.println("********* if base is null **********");
		 System.out.println();
		 
		 Beverage nullBase = new Milk(null);
		 
		 int cost2 = nullBase.getCost();
		 System.out.println("Total Cost : "+cost2);
		 
		 
	}

}
