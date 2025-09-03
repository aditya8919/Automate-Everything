package design_patterns_PROTOTYPE_REGISTRY;

public class Student
{

	String id;
	int marks;
	int age;
	
	
	public Student(Student s1 )
	{
		this.id = s1.id;
		this.marks = s1.marks;
		this.age = s1.age;
	}
	
	
	public Student copy(Student s1)
	{
		this.id = s1.id;
		this.marks = s1.marks;
		this.age = s1.age;
		
		return new Student(s1);
	}

	public String getId()
	{
		return id;
	}


	public void setId(String id)
	{
		this.id = id;
	}


	public int getMarks()
	{
		return marks;
	}


	public void setMarks(int marks)
	{
		this.marks = marks;
	}


	public int getAge()
	{
		return age;
	}


	public void setAge(int age)
	{
		this.age = age;
	}



	
	

}
