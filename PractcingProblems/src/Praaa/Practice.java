package Praaa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {

	public static void main(String[] args) {
     
		//Sorting map vaues using java 8 features
		Map<String, Integer> sorMap = new HashMap<String, Integer>();
		sorMap.put("A", 10);
		sorMap.put("B", 50);
		sorMap.put("c", 5);
		sorMap.put("D", 40);

		LinkedHashMap<String, Integer> ss = sorMap.entrySet().stream()
				.sorted((s1, s2) -> s1.getValue().compareTo(s2.getValue())).collect(Collectors.toMap(t -> t.getKey(),
						t -> t.getValue(), (olvalue, newvalue) -> olvalue, LinkedHashMap::new));

		System.out.println(ss);

		
		// create one function which takes input as 7 and return as 11 and if given input as 11 and then it will return as 7
		
	int va =	Practice.getValue(7);
	int va2 =	Practice.getValue(11);
	System.out.println(va);
	System.out.println(va2);
		
	// write a code for finding dublicate elements from the list using java 8
	// features.
	List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 2, 4, 9);
	Set<Integer> ssIntegers = new HashSet<Integer>();
	List<Integer> llIntegers = list.stream().filter(t -> !ssIntegers.add(t)).collect(Collectors.toList());

	System.out.println(llIntegers);
		
		
	// write a code for merge two array into a one array using java 8 features
	int[] a = { 1, 2, 3, 4, 5 };
	int[] b = { 6, 7, 8, 9, 10 };

	int[] ss1 = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();

	System.out.println(Arrays.toString(ss1));
		
		
	// find the first repeated character using java 8 features.
	String ssString = "Java Stream Api Is Very Good concept".replaceAll("\s", "").toLowerCase();
	String repacharString = Arrays.stream(ssString.split(""))
			.collect(Collectors.groupingBy(t -> t, Collectors.counting())).entrySet().stream()
			.filter(t -> t.getValue() > 1).map(t -> t.getKey()).findFirst().get();
	System.out.println(repacharString);
		
	// We have string that contains multiple words, find words which starts with b
	String ssString2 = "apple banana mango box been for auto bike";
	List<String> ssList = Arrays.stream(ssString2.split(" ")).filter(t -> t.startsWith("b"))
			.collect(Collectors.toList());
	System.out.println(ssList);
		
	}
	
	
	
	
	public static int getValue(int n)
	{
		return 7+11-n;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
