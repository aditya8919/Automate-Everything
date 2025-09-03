package design_pattern_decorator;

public abstract class Addons extends Beverage
{
	
	abstract int getCost();
	abstract String getDescription();
	
	abstract int getComboDiscount();

}
