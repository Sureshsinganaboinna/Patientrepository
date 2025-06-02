package Streams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewStream {

	public static void main(String[] args) {

		// How do you get last element of an array?
		String[] laStrings = { "One", "Two", "Three", "Four", "Five", "Six" };
		String lastelement1 = Arrays.stream(laStrings).skip(5).findFirst().get();
		List<String> listOfStrings = Arrays.asList(laStrings);
		String lastelement = listOfStrings.stream().skip(5).findFirst().get();
		System.out.println(lastelement);
		
	//	System.out.println(lastelement1);
		
		//Find the age of a person in years if the birthday has given?
		LocalDate birthday = LocalDate.of(1998, 03, 25);
		LocalDate today = LocalDate.now();
		System.out.println(ChronoUnit.YEARS.between(birthday, today));
		
		// Find first non-repeated character in a string?
		String inputString = "Java Concept Of The Day".replaceAll("\s+", "").toLowerCase();
		String[] spliStrings = inputString.split("");
		Map<String, Long> p = Arrays.stream(spliStrings)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		String inputString1 = p.entrySet().stream().filter(w -> w.getValue() == 1).map(s -> s.getKey()).findFirst()
				.get();
		System.out.println(inputString1);
	
                                    // Find first repeated character in a string?
	String inputString2 = "Java Concept Of The Day".replaceAll("\s+", "").toLowerCase();
	Map<String, Long> ttMap = Arrays.stream(inputString2.split(""))
			.collect(Collectors.groupingBy(t -> t, LinkedHashMap::new, Collectors.counting()));
	String firstrepatedchar = ttMap.entrySet().stream().filter(r -> r.getValue() > 1).map(y -> y.getKey()).findFirst()
			.get();
	System.out.println(firstrepatedchar);
	
	// Print duplicate characters in a string?
	String inpString = "Java Concept Of The Day".replaceAll("\s+", "").toLowerCase();
	Map<String, Long> yyy = Arrays.stream(inpString.split(""))
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	List<String> ducharIntegers = yyy.entrySet().stream().filter(ee -> ee.getValue() > 1).map(t -> t.getKey())
			.collect(Collectors.toList());
	System.out.println(ducharIntegers);
	
	// How do you extract duplicate elements from an array?
	List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
	Set<Integer> finddublicates = new HashSet<>();
	Set<Integer> listOfIntegers1 = listOfIntegers.stream().filter(t -> !finddublicates.add(t))
			.collect(Collectors.toSet());
	System.out.println(listOfIntegers1);
	
	// Given a list of strings, find out those strings which start with a number?
	List<String> listOfStrings1 = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
	listOfStrings1.stream().filter(t -> Character.isDigit(t.charAt(0))).forEach(t -> System.out.println(t));

	// How do you find the most repeated element in an array?
	List<String> listOfStrings2 = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book",
			"Pencil");
	Map<String, Long> ss = listOfStrings2.stream()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	Entry<String, Long> mostrepeted = ss.entrySet().stream().max(Map.Entry.comparingByValue()).get();
	System.out.println("most repeated key " + mostrepeted.getKey());
	System.out.println("most repeated value " + mostrepeted.getValue());
	
	//Reverse each word of a string using Java 8 streams?
	String str2 = "Java Concept Of The Day";
	String reversewordString = Arrays.stream(str2.split(" ")).map(t -> new StringBuffer(t).reverse())
			.collect(Collectors.joining(" "));
	System.out.println(reversewordString);
	
	// How do you find common elements between two arrays?
	List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);

	List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);

	List<Integer> commonelements = list1.stream().filter(t -> list2.contains(t)).collect(Collectors.toList());
	System.out.println(commonelements);
	
	// Given a list of strings, sort them according to increasing order of their length?
	List<String> listOfStrings3 = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
	listOfStrings3.stream().sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
			.forEach(t -> System.out.println(t));
	
	// Find second largest number in an integer array?
	List<Integer> listOfIntegers4 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
	int secondlargestnumber = listOfIntegers4.stream().sorted((s1, s2) -> Integer.compare(s2, s1)).skip(1).findFirst()
			.get();
	int secondlargestnumber1 = 	listOfIntegers4.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
	System.out.println(secondlargestnumber);
	//System.out.println(secondlargestnumber1);
	
	// Given an integer array, find sum and average of all elements?
	int[] a =  { 45, 12, 56, 15, 24, 75, 31, 89 };
	int sum = Arrays.stream(a).sum();
	double avarage = Arrays.stream(a).average().getAsDouble();
	System.out.println(sum);
	System.out.println(avarage);
	
	// How do you find sum of first 10 natural numbers?
		Integer suInteger = IntStream.rangeClosed(0, 10).sum();
		System.out.println(suInteger);
	//	IntStream.rangeClosed(0, 10).filter(t-> t/2==1).limit(10).forEach(null);
		
		// Palindrome program using Java 8 streams
		String str = "ROTATOR";
		boolean palindrom = IntStream.range(0, str.length() / 2)
				.noneMatch(t -> str.charAt(t) != str.charAt(str.length() - t - 1));
		if (palindrom) {
			System.out.println("String is a palindrom");
		} else {
			System.out.println("String is not a palindrom");
		}
		
		// First 10 odd numbers
	//	IntStream.iterate(1, n -> n + 2).limit(10).forEach(s -> System.out.println(s));
		// First 10 even numbers
	//	IntStream.iterate(2, n -> n + 2).limit(10).forEach(t -> System.out.println(t));
		
		//Print first 10 even numbers
		IntStream.rangeClosed(1, 10).map( t -> t*2 ).forEach(t -> System.out.println(t));
		
		//Reverse an integer array
		int[] array = new int[] {5, 1, 7, 3, 9, 6};
		int[] reversearray = IntStream.rangeClosed(1, array.length).map( t -> array[array.length-t]).toArray();
		System.out.println(Arrays.toString(reversearray));
		
	// Find sum of all digits of a number in Java 8?
	int i = 15623;
	int summ = String.valueOf(i).chars().map(c -> c - '0').sum();
	      String.valueOf(i).chars().mapToObj(t-> (Integer) t).mapToInt( e->e).sum();
	System.out.println(summ);
	
	// Java 8 program to check if two strings are anagrams or not?
	String s1 = "RaceCar";
	String s2 = "CarRace";
	s1 = Arrays.stream(s1.split("")).map(t -> t.toUpperCase()).sorted().collect(Collectors.joining());
	s2 = Arrays.stream(s2.split("")).map(t -> t.toUpperCase()).sorted().collect(Collectors.joining());
	if (s1.equals(s2)) {
		System.out.println("both are anargrams");
	} else {
		System.out.println("both are not anargrams");
	}
    
	// Given a list of integers, separate odd and even numbers?

	List<Integer> listOfIntegers3 = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
	List<Integer> evenumbers = listOfIntegers3.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
	List<Integer> oddnumbers = listOfIntegers3.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
	System.out.println(evenumbers);
	System.out.println(oddnumbers);
	
	// How do you remove duplicate elements from a list using Java 8 streams?
	List<String> listOfStrings4 = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
	List<String> distinctvalues = listOfStrings4.stream().distinct().collect(Collectors.toList());
	Set<String> distinctvalues1 = listOfStrings4.stream().collect(Collectors.toSet());
	System.out.println(distinctvalues);
	System.out.println(distinctvalues1);
	
	// How do you find frequency of each character in a string using Java 8 streams?
	String inputString4 = "Java Concept Of The Day";
	String[] splitstring = inputString4.replaceAll("\s+", "").toLowerCase().split("");
	Map<String, Long> frechar = Arrays.stream(splitstring).map(c -> c)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	System.out.println(frechar);
	
	// How do you find frequency of each element in an array or a list?
	List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book",
			"Pencil");
	Map<String, Long> sttt = stationeryList.stream()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	System.out.println(sttt);
	
	// How do you sort the given list of decimals in reverse order?
	List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
	List<Double> reverseorderdecimals = decimalList.stream().sorted(Comparator.reverseOrder())
			.collect(Collectors.toList());
	System.out.println(reverseorderdecimals);
	
	// Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix
	// and ‘,’ as delimiter?
	List<String> listOfStrings5 = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
	String listsStrings = listOfStrings5.stream().collect(Collectors.joining(",", "[", "]"));
	System.out.println(listsStrings);
	
	//From the given list of integers, print the numbers which are multiples of 5?
	List<Integer> listOfIntegers6 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
	List<Integer> listOfIntegers8 =listOfIntegers6.stream().filter(t->t%5==0).collect(Collectors.toList());
	System.out.println(listOfIntegers8);
	
	//Reverse a LinkedList (Streams API)
	LinkedList<Integer> linkedList = new LinkedList<Integer>(List.of(10, 20, 30, 40, 50));
	// LinkedList<Integer> list = new LinkedList<>(List.of(10, 20, 30, 40, 50));
	List<Integer> llIntegers = linkedList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	System.out.println(llIntegers);
	
      //Find Duplicates in an Array (Streams API)
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 3, 7, 8, 8);
      
      Set<Integer> haSet = new HashSet<Integer>();
      
    Set<Integer> smm = numbers.stream().filter( t->!haSet.add(t)).collect(Collectors.toSet());
    List<Integer> smm1 =           numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                      .filter( e -> e.getValue() >1).map( r -> r.getKey()).collect(Collectors.toList());
	System.out.println(smm);
	System.out.println(smm1);
	
	//Frequency of Characters in a String (Streams API)
	String input = "hello world";
     String[] spliarrStrings = input.split("");
    Map<String, Long> sssMap =   Arrays.stream(spliarrStrings).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
	System.out.println(sssMap);
	
//	
//	List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 3, 7, 8, 8, 2, 2);
//
//	List<Integer> result = Stream.concat(numbers2.stream().filter(t -> t != 2), numbers2.stream().filter(t -> t == 2))
//	                             .collect(Collectors.toList());
//
//	System.out.println(result);

}

}
