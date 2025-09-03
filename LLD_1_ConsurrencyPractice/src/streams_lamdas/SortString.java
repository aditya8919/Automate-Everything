package streams_lamdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortString
{

	/**
	 * I want to sort words in this string as per ascending order of number of
	 * letters in each word using Streams.
	 */
	public static void sortStringWords()
	{
		String s1 = "I like to play with my dog";

		String[] s2 = s1.split(" ");

		List<String> list = List.of(s2);

		String sorted = Arrays.stream(s2).sorted((a, b) -> Integer.compare(a.length(), b.length()))
				.collect(Collectors.joining(" "));

		System.out.println(sorted);
	}
	
	/**
	 * - Count the number of vowels in each word of a sentence using streams.
	 * - Output format: {word=vowelCount}
	 */
	public static void countVowels()
	{
//		String s1 = "I like to play with my dog";
//		
//		 String[] arr = s1.split(" ");
//		 
//		 Object ss = Arrays.asList(arr).stream()
//		 										.map((s,n) -> (s.contains('a') ||s.contains('e')))
//		 										.collect(Collectors.toMap(String, Integer));
		
		
	}

	public static void main(String[] args)
	{
		sortStringWords();
	}

}
