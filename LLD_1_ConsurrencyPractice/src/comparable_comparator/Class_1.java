package comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Class_1 implements Comparable<Integer>
{
	
	public static void main(String[] args)
	{
		
		List<Integer> list = new ArrayList<>(List.of(3,2,5,1,6,7));
		
		Collections.sort(list);
		
		
		
		
		
		
	}

	@Override
	public int compareTo(Integer o)
	{
		
		return 0;
	}

}
