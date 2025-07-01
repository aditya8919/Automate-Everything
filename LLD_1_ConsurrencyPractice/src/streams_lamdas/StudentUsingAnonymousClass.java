package streams_lamdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import comparable_comparator.Student;

public class StudentUsingAnonymousClass implements Comparable<StudentUsingAnonymousClass>
{
	String name;
	int age;
	int marks;

	public StudentUsingAnonymousClass(String name, int age, int marks)
	{
		super();
		this.name = name;
		this.age = age;
		this.marks = marks;
	}

	/**
	 * When we use Comparable, we can sort the collection using only 1 criteria
	 * here, its based on Marks
	 * 
	 * Sometimes we need to sort the objects based on age, marks or name
	 * In that case, we need to create a separate class which implements 
	 * Comparator interface. 
	 */
	@Override
	public int compareTo(StudentUsingAnonymousClass o)
	{
		// desc order

		if (this.marks > o.marks)
			return -1;
		else if (this.marks < o.marks)
			return 1;

		return 0;
	}

	public static void main(String[] args)
	{
		StudentUsingAnonymousClass s1 = new StudentUsingAnonymousClass("A", 24, 40);
		StudentUsingAnonymousClass s2 = new StudentUsingAnonymousClass("B", 29, 50);
		StudentUsingAnonymousClass s3 = new StudentUsingAnonymousClass("C", 22, 65);
		StudentUsingAnonymousClass s4 = new StudentUsingAnonymousClass("D", 23, 20);
		StudentUsingAnonymousClass s5 = new StudentUsingAnonymousClass("E", 27, 30);
		
		List<StudentUsingAnonymousClass> list = new ArrayList<StudentUsingAnonymousClass>();
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		
		
		
		System.out.println();
		System.out.println("**** Comparable - desc marks ********");
		System.out.println();
		
		Collections.sort(list);
		
//		System.out.println(list);
		
		for(StudentUsingAnonymousClass s : list)
		{
			System.out.println(s.name + " " + s.marks);
		}
		
		System.out.println();
		System.out.println("**** Comparator - asc age using anonymous class********");
		System.out.println();
		
		
		Comparator<StudentUsingAnonymousClass> comp  = new Comparator<StudentUsingAnonymousClass>()
		{
			
			@Override
			public int compare(StudentUsingAnonymousClass o1, StudentUsingAnonymousClass o2)
			{
//			Asc order sort
				
				if(o1.age > o2.age )
					return 1;
				else if(o1.age < o2.age )
					return -1;
				
				return 0;
			}
		}; 
		
		Collections.sort(list, comp);
		
		for(StudentUsingAnonymousClass s : list)
		{
			System.out.println(s.name + " " + s.age);
		}
		
		
		
		
		
		
		
		
	}

}
