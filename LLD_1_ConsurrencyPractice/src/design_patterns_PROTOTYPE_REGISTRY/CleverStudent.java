package design_patterns_PROTOTYPE_REGISTRY;

public class CleverStudent extends Student 
{


	int iq;
	boolean libraryPass;
	
	public CleverStudent(CleverStudent cs1)
	{
		super(null);
		this.iq = cs1.iq;
		this.libraryPass = cs1.libraryPass;
	}

	
	public int getIq()
	{
		return iq;
	}

	public void setIq(int iq)
	{
		this.iq = iq;
	}

	public boolean isLibraryPass()
	{
		return libraryPass;
	}

	public void setLibraryPass(boolean libraryPass)
	{
		this.libraryPass = libraryPass;
	}
	
	public CleverStudent copy(CleverStudent cv1)
	{
		
		return new CleverStudent(cv1);
	}

}
