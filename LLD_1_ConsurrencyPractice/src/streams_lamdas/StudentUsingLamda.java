package streams_lamdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentUsingLamda implements Comparable<StudentUsingLamda>
{
	String name;
	int age;
	int marks;

	public StudentUsingLamda(String name, int age, int marks)
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
	 * Sometimes we need to sort the objects based on age, marks or name In that
	 * case, we need to create a separate class which implements Comparator
	 * interface.
	 */
	@Override
	public int compareTo(StudentUsingLamda o)
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
		StudentUsingLamda s1 = new StudentUsingLamda("A", 24, 40);
		StudentUsingLamda s2 = new StudentUsingLamda("B", 29, 50);
		StudentUsingLamda s3 = new StudentUsingLamda("C", 22, 65);
		StudentUsingLamda s4 = new StudentUsingLamda("D", 23, 20);
		StudentUsingLamda s5 = new StudentUsingLamda("E", 27, 30);

		List<StudentUsingLamda> list = new ArrayList<StudentUsingLamda>();

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

		for (StudentUsingLamda s : list)
		{
			System.out.println(s.name + " " + s.marks);
		}

		System.out.println();
		System.out.println("**** Comparator - asc age using lamda expression ********");
		System.out.println();

//		Comparator<StudentUsingLamda2> comp  = new Comparator<StudentUsingLamda2>()
//		{
//			
//			@Override
//			public int compare(StudentUsingLamda2 o1, StudentUsingLamda2 o2)
//			{
////			Asc order sort
//				
//				if(o1.age > o2.age )
//					return 1;
//				else if(o1.age < o2.age )
//					return -1;
//				
//				return 0;
//			}
//		}; 

		/**
		 * Lamda expressions are used to implement only function interfaces (Comparator here). 
		 * In functional interface, only 1 method is there. Hence Lamda Expressions
		 * we don't need to mention method name and return type. 
		 * Java used the only method available; we just need to provide arguments of 
		 * that method (if any) as below 
		 */
		Comparator<StudentUsingLamda> comp2 = (StudentUsingLamda o1, StudentUsingLamda o2) ->
		{
//	Asc order sort

			if (o1.age > o2.age)
				return 1;
			else if (o1.age < o2.age)
				return -1;

			return 0;

		};

		Collections.sort(list, comp2);

		for (StudentUsingLamda s : list)
		{
			System.out.println(s.name + " " + s.age);
		}

	}

}
