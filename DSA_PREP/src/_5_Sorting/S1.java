package _5_Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class S1
{
	
	public static void nobelIntegers(int []  arr)
	{

		
		for(int j = 0; j<arr.length; j++)
		{
			int min = arr[j];
			int temp = 0;
			
			for(int i = j; i < arr.length; i++)
			{
				if(arr[i] < min)
				{
					temp = arr[i];
					arr[i] = min;
					min = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void main(String[] args)
	{
		
		int [] arr = {3,8,2,-1,5,-3};
		
		nobelIntegers(arr);
		
		
		
	}
	

}
