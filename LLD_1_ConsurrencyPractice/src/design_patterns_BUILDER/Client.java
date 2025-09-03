package design_patterns_BUILDER;

public class Client
{

	public static void main(String[] args)
	{

//		Version 1

//		StudentBuilder studentBuilder = new StudentBuilder();
//		studentBuilder.setName("ABC");
//		studentBuilder.setAge(30);
//		studentBuilder.setEmail("Email");
//		studentBuilder.setPsp(90);
//		
//		
//		Student s1  = new Student(studentBuilder);

//		Version 2

//		StudentBuilder studentBuilder = Student.getBuilder();
//		
//		studentBuilder.setName("ABC");
//		studentBuilder.setAge(30);
//		studentBuilder.setEmail("Email");
//		studentBuilder.setPsp(90);
//		
//		Student s1  = new Student(studentBuilder);
		
//	Version 3
//		
//		StudentBuilder studentBuilder = Student.getBuilder()
//																			.setAge(30)
//																			.setEmail("Email")
//																			.setName("ABC")
//																			.setPsp(90);
//		
//		Student s1  = new Student(studentBuilder);
		
		
		
//		Version 4
		
//		Student s1 = Student.getBuilder()
//									.setAge(30)
//									.setEmail("Email")
//									.setName("ABC")
//									.setPsp(90)
//									.build();
		
		
//		Student s1  = new Student(null);  --> this is still possible. 
//		hence below is final solution
		
		
		
//		Version 5  -- FINAL SOLUTION OF BUILDER PATTERN
		
//		We are making 'StudentBuilder' class as inner class of "Student" class
//		and make Student class constructor as private which will ensure 
//		that no other class can create its object.
		
		
//		Student s2  = new Student(null);  --> not possible now
		
		Student s1 = Student.getBuilder()
				.setAge(30)
				.setEmail("Email")
				.setName("ABC")
				.setPsp(90)
				.build();
		
		
		

	}

}
