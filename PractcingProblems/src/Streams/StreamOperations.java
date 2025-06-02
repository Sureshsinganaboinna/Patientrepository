package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;



public class StreamOperations {

	public static void main(String[] args) {
		 //find unique numbers from a list 
			List<Integer> nuIntegers = Arrays.asList(1,1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8, 10);
			List<Integer> uniquenumbersIntegers = nuIntegers.stream()
	                .filter(s -> nuIntegers.stream().filter(n -> n.equals(s)).count() == 1) // Correct placement of count()
	                .collect(Collectors.toList());
			// find dublicate numbers in a list
			List<Integer> numbers1 = Arrays.asList(1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8, 8);
			Set<Integer> sethas = new HashSet<Integer>();
			Set<Integer> sethass = numbers1.stream().filter(p -> !sethas.add(p)).collect(Collectors.toSet());
			System.out.println(sethass);
			
			  //multiple by 2's using functional interface
			 // count the number of occurence of words in given string using java 8
				String str = "welcome to code decode and code decode welcome code";
				Map<String, Long> numberoccureofwords = Arrays.stream(str.split(" "))
						.collect(Collectors.groupingBy(t -> t, Collectors.counting()));
				System.out.println(numberoccureofwords);
//				numberoccureofwords.entrySet().stream()
//						.forEach(y -> System.out.println("Key :" + y.getKey() + "  Value :" + y.getValue()));
//				
				//List of list of strings flatten them into single list of strings
				List<List<String>> listoflistofstrings = Arrays.asList(Arrays.asList("one", "two"),
						Arrays.asList("three", "Four"));
				List<String> stree = listoflistofstrings.stream()
						.flatMap(listoflisto -> listoflisto.stream()).collect(Collectors.toList());
				System.out.println(stree);
			
				// A list of strings, each containing multiple words.
				List<String> sentences = Arrays.asList("Hello World", "Java 8 Streams", "FlatMap Example");
				List<String> stre =	   sentences.stream().flatMap(sente -> Arrays.stream(sente.split(" "))).collect(Collectors.toList());
				System.out.println(stre);
				
				//find common elements from given two lists
				List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
				List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
			List<Integer>dd	=list1.stream().filter(list -> list2.contains(list)).collect(Collectors.toList());
				System.out.println(dd);
				 // How do you find frequency of each character in a string using Java 8 streams?
					String str1 = "Hello hyderabad How are you".replaceAll("\\s+", "").toLowerCase();
				//	System.out.println(str1);
					Map<String, Long> numberoccofchar = Arrays.stream(str1.split(""))
							.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
					System.out.println(numberoccofchar);
					Map<Character, Long> numberoccofchar1 	= str1.chars().mapToObj(c ->(char) c).collect(Collectors.groupingBy(r -> r, Collectors.counting()));
					System.out.println(numberoccofchar1);
				// find the number of occurenec of given char(o) in string 
					String str2 = "welcomtomonocept";
					char targetchar = 'o';
					//str2.chars().filter( e ->(char) e )
				Long charcount	= Arrays.stream(str2.split("")).filter(e->e.equals(String.valueOf(targetchar))).count();
			        System.out.println(charcount);
			       Long  accurencesof = str2.chars().filter( tt -> tt =='o').count();
			        System.out.println(accurencesof);
			          
			        
			        
		}

}
