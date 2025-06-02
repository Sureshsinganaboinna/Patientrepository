package Streams;


import java.util.Arrays;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.jar.Attributes.Name;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class Stream {

	public static void main(String[] args) {
	//	A Stream in Java is a sequence of data elements that can be processed using various operations
		//like filtering, mapping, and reducing, typically in a functional style.
		//intermediate operations are used to transform stream and return a another stream. they are in lazy nature. because of
		//operations are not executed until terminal operation is called.
		//key points return new stream, they are not executed but rather when the stream pipeline is terminated by 
		//can be chained together to form a processing pipe line.
		//Filter
   //A parallel stream in Java is a stream that processes data using multiple threads at the same time to speed up operations.
		
		//Fetch all the numbers which are greater then 5
		
	/*	List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		List<Integer> filtervalues = numbers.stream().filter(n -> n>5).collect(Collectors.toList());
		System.out.println(filtervalues);
	   
		List<Integer> vaIntegers = numbers.stream().filter(num -> num >5).collect(Collectors.toList());
		System.out.println(vaIntegers);
		
		//Map
		//Transfer list of strings into a list of their uppercase version
		
		List<String> stringvalues = Arrays.asList("apple","banana","cherry");
		List<String> stringuppercasevaluesList = stringvalues.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(stringuppercasevaluesList);
		
		 List<String> valuess = stringvalues
				                            .stream()
				                                     .map(Maa -> Maa.toUpperCase())
				                                                                   .collect(Collectors.toList());
		 System.out.println(valuess + "=================");
		
		List<String> stringUppercaseValuesList = 
			    Arrays.asList("apple", "banana", "cherry")
			          .stream()
			          .map(s -> s.toUpperCase())  // Using lambda instead of method reference
			          .collect(Collectors.toList());

			System.out.println(stringUppercaseValuesList);
	
		//FlatMap
		//List of list of strings flatten them into single list of strings
		
		List<List<String>> listoflistofstrings = Arrays.asList(Arrays.asList("one","two"), Arrays.asList("three","Four"));
                       		
		List<String> liststringList = listoflistofstrings.stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println(liststringList);
		
		List<List<String>> listOfListOfStrings = Arrays.asList(
			    Arrays.asList("one", "two"), 
			    Arrays.asList("three", "four")
			);
			List<String> listStringList = listOfListOfStrings.stream()
			                                                 .flatMap(list -> list.stream())  // Using lambda instead of Collection::stream
			                                                 .collect(Collectors.toList());
			System.out.println(listStringList);
			
		//Distinct
		//Remove dublicates from list of integers.
		
		List<Integer> values = Arrays.asList(1,1,1,2,3,3,5,6,6,1,2,4,4,6);
		List<Integer> distinctvalues = values.stream().distinct().collect(Collectors.toList());
		Set<Integer> distinctvalues11 = values.stream().collect(Collectors.toSet());
		System.out.println(distinctvalues);
		System.out.println(distinctvalues11);
		
		//Sorted
		//Sort a list of names in reverse alphabetical order
		List<String> wordS = Arrays.asList("Ram","Jan","Suresh","karthik");
		List<String> streamwordS = wordS.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		System.out.println(streamwordS);
		
		//peek
		//print each element in a list while converting them to uppercase
		
		List<String> wordS2 = Arrays.asList("Ram","Jan","Suresh","karthik");
		List<String> result = wordS2.stream()
				                 .peek(wordSs -> System.out.println("Original:"+wordSs))
				                  .map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(result);
		
		//limit
		//fetch first 3 elements from list of integers
		
		List<Integer> values1 = Arrays.asList(1,2,5,4,7,8);
		List<Integer> limitvalues = values1.stream().limit(3).collect(Collectors.toList());
		System.out.println(limitvalues);
		
		//skip
		//skip first 4 elements from the list of integer and print rest of the numbers.
		List<Integer> values2 = Arrays.asList(1,2,5,4,7,8);
		
		List<Integer> valuesafterskip = values2.stream().skip(3).collect(Collectors.toList());
		System.out.println(valuesafterskip);*/
		
		//Terminal operations 
		//Terminal operations  are used to triggers the execution of the stream pipeline. they eager in nature means they execute
		//entire pipeline and produce a result
		//Key points:- triggers the execution of the intermediate operations
	/*	
		//foreach
		List<String> stringvalues1 = Arrays.asList("apple","banana","cherry");
		stringvalues1.stream().forEach(eachone -> System.out.println(eachone));
		
		stringvalues1.stream().filter(eachone -> eachone.length()>5).forEach(eachone -> System.out.println(eachone));
		
		stringvalues1.stream().forEach(eachone -> System.out.println(eachone));
		stringvalues1.stream().filter(eachone -> eachone.length()>6).forEach(eachone -> System.out.println(eachone));
		
	//collect
		//collect the list of integers into a set
		List<Integer> values3 = Arrays.asList(1,2,2,3,3,5,4,7,8);
		Set<Integer> setvalues = values3.stream().collect(Collectors.toSet());
		System.out.println(setvalues);
		
	       Set<Integer> values = values3.stream().collect(Collectors.toSet());
	
		//reduce
		//compute the product of all the numbers of list
		//reduce method in java is used to perform a reduction on the elements of a stream
		List<Integer> values4 = Arrays.asList(1,2,3,4,5);
		
		 Optional<Integer> production = values4.stream().reduce((a,b) -> a*b);
		System.out.println(production);
		    Optional<Integer> pro = values4.stream().reduce((a,b) -> a*b);
		     System.out.println(pro);
		     
		//Allmatch
		//
		List<Integer> values5 = Arrays.asList(1, 2, 3, 4, 5);
		boolean result12 = values5.stream().allMatch(n -> n > 0);
		System.out.println(result12);
		
		values5.stream().allMatch(s -> s>6);
		
		// anymatch
		List<Integer> values6 = Arrays.asList(1, 2, 3, 4, 5);
		boolean result123 = values6.stream().anyMatch(n -> n > 3);
		System.out.println(result123);
		
		values6.stream().anyMatch(ss->ss>5);
		
		// nonematch
		List<Integer> values7 = Arrays.asList(1, 2, 3, 4, 5);
		boolean result1234 = values7.stream().noneMatch(n -> n > 2);
		System.out.println(result1234);
		
		values7.stream().noneMatch(m->m>4);
						
		//findfirst
		
				List<String> stringvalues2 = Arrays.asList("apple","banana","cherry","bada");
			Optional<String> fruitsOptional =	stringvalues1.stream().filter(wordS1 -> wordS1.startsWith("b")).findFirst();
				
			System.out.println(fruitsOptional);		
				
			findlast	
				List<String> stringvalues3 = Arrays.asList("appl","banana","cherry","bfgfds");
				Optional<String> fruitsOptional1 =	stringvalues1.stream().filter(wordS1 -> wordS1.startsWith("b")).findAny();
					
					System.out.println(fruitsOptional1);		
				
		
	/*	1) //find unique numbers from a list 
		   List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8);

		   numbers.stream().filter(n -> numbers.stream().filter(x -> x.equals(n)).count() == 1).forEach( s -> System.out.println(s));
		   
		*/   
		
	/*	2) //find dublicate numbers in a list
		
		   List<Integer> numbers1 = Arrays.asList(1, 2, 2,2, 3, 4, 4, 5, 6, 6, 7, 8, 8,8);
		   Set<Integer> set = new HashSet<Integer>();
		   numbers1.stream().filter(n-> !set.add(n)).collect(Collectors.toSet()).forEach( x -> System.out.println(x));
		   
		//   .collect(Collectors.toSet()).forEach( x -> System.out.println(x));*/
		   
	//	3)   //multiple by 2's using functional interface
	//=================================================================================================	   
		 // 4 // count the number of occurence of words in given string using java 8
		
	String str = "welcome to code decode and code decode welcome code";

	List<String> list = Arrays.asList(str.split(" "));

	Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	Map<String, Long> kk = list.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));

	List<String> valueSet = kk.entrySet().stream().filter(du -> du.getValue() > 1).map(k -> k.getKey())
			.collect(Collectors.toList());
	System.out.println(map);
	System.out.println(valueSet);
	Set<String> ss = list.stream().filter(name -> Collections.frequency(list, name) > 1).collect(Collectors.toSet());
	System.out.println(ss);
		
//=====================================================================================		
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
		List<Integer> intersection = list1.stream()
		                                  .filter(list2::contains)
		                                  .collect(Collectors.toList());
		List<Integer> intersection1 = list1.stream().filter( n -> list2.contains(n)).collect(Collectors.toList());
		
		System.out.println(intersection);
		System.out.println(intersection1);
	
		
		List<Integer> values5 = Arrays.asList(1, 2, 3, 4, 5);
		boolean result12 = values5.stream().allMatch(n -> n > 0);
		System.out.println(result12);
		
		values5.stream().allMatch(s -> s>6);
		
		// anymatch
		List<Integer> values6 = Arrays.asList(1, 2, 3, 4, 5);
		boolean result123 = values6.stream().anyMatch(n -> n > 3);
		System.out.println(result123);
		
	//	values6.stream().anyMatch(ss->ss>5);
		
		// nonematch
		List<Integer> values7 = Arrays.asList(1, 2, 3, 4, 5);
		boolean result1234 = values7.stream().noneMatch(n -> n > 6);
		System.out.println(result1234);
		
		values7.stream().noneMatch(m->m>4);
//=================================================================================
		/*   
	        numbers.stream()
	                .filter(n -> numbers.stream().filter(x -> x.equals(n)).count() == 1)
	                .forEach(System.out::println);
	                
		List<Integer> numbers1 = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8);                           //ArrayList<Integer> (1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8);
        
		List<Integer> uniquenumbers = numbers1.stream().distinct().collect(Collectors.toList());
		
		System.out.println(uniquenumbers); 
		
		*/
		//FlatMap
				//List of list of strings flatten them into single list of strings
		/*		
				List<List<String>> listoflistofstrings = Arrays.asList(Arrays.asList("one","two"), Arrays.asList("three","Four"));
				
				List<String> liststringList = listoflistofstrings.stream().flatMap(Collection::stream).collect(Collectors.toList());
				
				List<String> liststringList11 =		listoflistofstrings.stream().flatMap( numbers1 -> numbers1.stream()).collect(Collectors.toList());
				System.out.println(liststringList);
				System.out.println(liststringList11);
				*/
				
		
		
		
	/*	
		TreeMap<Integer, String> hashM = new TreeMap<Integer, String>();
		hashM.put(1, "suresh");	
		hashM.put(2, "ram");		
		hashM.put(4, "sunil");
		hashM.put(3, "anil");
		hashM.put(6, "kaa");
		
		TreeMap<Integer, String> hashM1 = new TreeMap<Integer, String>();
		hashM1.put(null, "suresh");	
		hashM1.put(null, "ram");	
		
		System.out.println(hashM1);
		
		*/
		
		
	
		
		
	}

}