package comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student>
{
	String name;
	int age;
	int marks;

	public Student(String name, int age, int marks)
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
	public int compareTo(Student o)
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
		Student s1 = new Student("A", 24, 40);
		Student s2 = new Student("B", 29, 50);
		Student s3 = new Student("C", 22, 65);
		Student s4 = new Student("D", 23, 20);
		Student s5 = new Student("E", 27, 30);

		List<Student> list = new ArrayList<Student>();

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

		for (Student s : list)
		{
			System.out.println(s.name + " " + s.marks);
		}

		System.out.println();
		System.out.println("**** Comparator - asc age  ********");
		System.out.println();

		Collections.sort(list, new StudentAgeComparator());

		for (Student s : list)
		{
			System.out.println(s.name + " " + s.age);
		}
	}

}
