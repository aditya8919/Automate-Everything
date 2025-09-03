package design_patterns_BUILDER;

import javax.management.RuntimeErrorException;

public class Student
{
	String name;
	int age;
	int psp;

	String email;

	private Student(StudentBuilder studentBuilder)
	{

//		if (studentBuilder.email == null)
//		{
//			throw new RuntimeErrorException(null, "Email is null");
//		}
//		
//		this.name = studentBuilder.getName();
//		this.age = studentBuilder.getAge();
//		this.psp = studentBuilder.getPsp();
//		this.email = studentBuilder.getEmail();
//
//		System.out.println("Student Object Created");

	}

	public static StudentBuilder getBuilder()
	{
		
		return  new StudentBuilder();
		
	}
	
	
	public static class StudentBuilder
	{
		String name;
		int age;
		int psp;
		String email;
		
		
		
		public String getName()
		{
			return name;
		}
		public StudentBuilder setName(String name)
		{
			this.name = name;
			
			return this;
		}
		public int getAge()
		{
			return age;
		}
		public StudentBuilder setAge(int age)
		{
			this.age = age;
			return this;
		}
		public int getPsp()
		{
			return psp;
		}

		public StudentBuilder setPsp(int psp)
		{
			this.psp = psp;
			return this;
		}
		public String getEmail()
		{
			return email;
		}
		public StudentBuilder setEmail(String email)
		{
			this.email = email;
			return this;
		}
		
		public Student build()
		{
			if (this.email == null)
			{
				throw new RuntimeErrorException(null, "Email is null");
			}
			
			this.name = this.getName();
			this.age = this.getAge();
			this.psp = this.getPsp();
			this.email = this.getEmail();

			System.out.println("Student Object Created");
			
			return new Student(this);
		}
	}

}
