package comparable_comparator;

import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student>
{

	@Override
	public int compare(Student s1, Student s2)
	{
		
//		Asc order sort
		
		if(s1.age > s2.age )
			return 1;
		else if(s1.age < s2.age )
			return -1;
		
		
		
		return 0;
	}

}
