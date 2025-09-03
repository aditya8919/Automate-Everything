package design_patterns_PROTOTYPE_REGISTRY;

public class DullStudent extends Student 
{
	


	boolean sportsQuota;
	String fitnessLevel;
	
	public DullStudent(DullStudent ds1)
	{
		super(null);
		this.sportsQuota = ds1.sportsQuota;
		this.fitnessLevel = ds1.fitnessLevel;
	}
	

	
	
	public boolean isSportsQuota()
	{
		return sportsQuota;
	}

	public void setSportsQuota(boolean sportsQuota)
	{
		this.sportsQuota = sportsQuota;
	}

	public String getFitnessLevel()
	{
		return fitnessLevel;
	}

	public void setFitnessLevel(String fitnessLevel)
	{
		this.fitnessLevel = fitnessLevel;
	}

	public DullStudent copy(DullStudent ds1)
	{
		
		return new DullStudent(ds1);
	}
	

}
