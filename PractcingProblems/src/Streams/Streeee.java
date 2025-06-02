package Streams;

import java.time.LocalDate;


import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.security.auth.callback.LanguageCallback;




public class Streeee {

	public static void main(String[] args) {

	//	Find the age of a person in years if the birthday has given?
		
		LocalDate birthdayDate = LocalDate.of(1998, 03, 25);
        LocalDate today = LocalDate.now();
        System.out.println(ChronoUnit.YEARS.between(birthdayDate, today));
        Period period = Period.between(birthdayDate, today);
        
        System.out.println(period.getYears() +"years  "+ period.getMonths()+"months  "+period.getDays()+"days");
        
        // How do you get last element of an array?
        List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
        
             String lastelemetString  = listOfStrings.stream().skip(5).findFirst().get();
             
             System.out.println(lastelemetString);
        
             //First 10 odd numbers
             
      /*       Stream.iterate(new int[] {1, 3}, f -> new int[] {f[1], f[1]+2})
             .limit(10)
             .map(f -> f[0])
             .forEach(i -> System.out.print(i+" "));
        */
             
             //Print duplicate characters in a string?
             String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
             String iiiString = "java concept of the day".replaceAll("\\s+","").toLowerCase();
            		 System.out.println(inputString);
             String[] jjStrings = inputString.split("");
            
             List<String> ssStrings = Arrays.asList(jjStrings);
             Set<String> uniqueChars = new HashSet<>();        
            
             Set<String> duplicateChars = 
                     Arrays.stream(inputString.split(""))
                             .filter(ch -> ! uniqueChars.add(ch))
                             .collect(Collectors.toSet());
             System.out.println(duplicateChars);
             
           //  10) How do you merge two unsorted arrays into single sorted array without duplicates?
            int[] a = new int[] {4, 2, 5, 1};
            int[] b = new int[] {8, 1, 9, 5};
            
            int[] c =IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().toArray();
            System.out.println(Arrays.toString(c));
            
           // 11) How do you get three maximum numbers and three minimum numbers from the given list of integers?
            
            List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
                List<Integer> vaIntegers  =  listOfIntegers.stream().sorted().limit(3).collect(Collectors.toList());
            System.out.println("three minmum numbers :- "+ vaIntegers);
            List<Integer> vaIntegers1  =  listOfIntegers.stream().sorted().skip(5).collect(Collectors.toList());
            System.out.println("three maximum numbers :- "+ vaIntegers1);
            
			// 12) Java 8 program to check if two strings are anagrams or not?
			String s1 = "RaceCar";
			String s2 = "CarRace";

			String ss1 = Arrays.stream(s1.split("")).map(s -> s.toUpperCase()).sorted().collect(Collectors.joining());
			String ss2 = Arrays.stream(s2.split("")).map(t -> t.toUpperCase()).sorted().collect(Collectors.joining());
			if (ss1.equals(ss2)) {
				System.out.println("Two string are anagrams");
			} else {
				System.out.println("Two strings are not a anagrams");
			}
     
         //   13) Find sum of all digits of a number in Java 8?
            
			int c1 = 15623;
			int summ = String.valueOf(c1).chars().map(Character::getNumericValue).sum();
			System.out.println(summ);
			int i = 15623;
			
			
			int sum = Integer.toString(i) // Step 1: Convert integer to a string
			               .chars()       // Step 2: Stream over each character of the string
			               .map(p -> p - '0') // Step 3: Convert character to numeric value
			               .sum();        // Step 4: Sum all the numeric values

			System.out.println(sum); // Output: 17
		
			//14) Find second largest number in an integer array?
			List<Integer> listOfIntegers1 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		int sss=	listOfIntegers1.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		
		System.out.println(sss);
		
		//15) Given a list of strings, sort them according to increasing order of their length?
		List<String> listOfStrings2 = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
	         listOfStrings2.stream().sorted(Comparator.comparing( s-> s.length())).forEach( p -> System.out.println(p));
	       //16) Given an integer array, find sum and average of all elements?
	         int[] y = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
	         int summ1 = Arrays.stream(y).sum();
	         double avarage = Arrays.stream(y).average().getAsDouble();
	        
	         System.out.println("summ  "+ summ1 +" and "+avarage);
	         
	         //17) How do you find common elements between two arrays?
	         
	         List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
	         List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
	         
	         list1.stream().filter(lis -> list2.contains(lis)).forEach( e -> System.out.println(e));
            
				// 18) Reverse each word of a string using Java 8 streams?

				String str = "Java Concept Of The Day";
				String[] ssStrings2 = str.split(" ");

				List<String> ssStrings3 = Arrays.asList(ssStrings2);
				String reversewaord = ssStrings3.stream().map(q -> new StringBuffer(q).reverse())
						.collect(Collectors.joining(" ")).toString();
				System.out.println(reversewaord);
	         
	        // 19) How do you find sum of first 10 natural numbers?
	         
	         int summation = IntStream.range(1, 11).sum();
	         System.out.println(summation);
	         
	       //  20) Reverse an integer array
	         
	         int[] array = new int[] {5, 1, 7, 3, 9, 6};
	         Arrays.stream(array).sum();
	         
	         
	      int[] reversearray =   IntStream.rangeClosed(1, array.length).map( i1 -> array[array.length-i1]).toArray();
	         
	      IntStream.rangeClosed(1, array.length).map( kkk -> array[array.length - kkk]).toArray();
	      
	         System.out.println(Arrays.toString(reversearray));
	         
	         //Print first 10 even numbers     
	         IntStream.rangeClosed(1, 10).map(i2 -> i2 * 2).forEach(System.out::println);
	         
	       //  22) How do you find the most repeated element in an array?
	         
			List<String> listOfStrings3 = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen",
					"Note Book", "Pencil");
			Map<String, Long> valuekeysMap = listOfStrings3.stream()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			Entry<String, Long> dd = valuekeysMap.entrySet().stream().filter(a1 -> a1.getValue() > 1).findFirst().get();
			System.out.println(dd.getKey());
			Entry<String, Long> repeatedelementMap = valuekeysMap.entrySet().stream().max(Map.Entry.comparingByValue())
					.get();

			valuekeysMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();

			System.out.println("Most repeated element :- " + repeatedelementMap.getKey());
			System.out.println("Count " + repeatedelementMap.getValue());

	   // 23) Palindrome program using Java 8 streams
	    
	    String st = "ROTATOR";
	    
	  boolean isItPalindrome =  IntStream.range(0, st.length()/2).noneMatch( w -> st.charAt(w)!= st.charAt(st.length()-w-1));
	    
	  boolean isItPalindrome1 =   IntStream.range(0, st.length()/2).allMatch(aaa -> st.charAt(aaa) == st.charAt(st.length()-aaa-1));
	  
	  
	    if (isItPalindrome1) {
			System.out.println("Given String is palindrom");
		}
	    else {
	    	System.out.println("Given String is not palindrom");
		}
	    
	    
	 //   24) Given a list of strings, find out those strings which start with a number?
	    
	    List<String> listOfString = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
	    
	    listOfString.stream().filter( ee -> Character.isDigit(ee.charAt(0))).forEach( yy -> System.out.println(yy));
	    
	    listOfString.stream().filter( mm -> Character.isDigit(mm.charAt(0))).forEach( sss1 -> System.out.println(sss1));
	    
	    
		// 25) How do you extract duplicate elements from an array?

		List<Integer> listOfInteg = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);

		Set<Integer> ssSet = new HashSet<Integer>();

		Set<Integer> dubvalueSet = listOfInteg.stream().filter(tt -> !ssSet.add(tt)).collect(Collectors.toSet());
		System.out.println(dubvalueSet);
	 
		//26) Print duplicate characters in a string?
		String inputStrin = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
	        String[] spliStrings = inputString.split("");
	        Set<String> ssSet1 = new HashSet<String>();
	        
	  Set<String>  ssss =    Arrays.stream(inputString.split("")).filter(Stri -> !ssSet1.add(Stri)).collect(Collectors.toSet());
	        
	 System.out.println(ssss);
	 
	 
	// 27) Find first repeated character in a string?
	 
	String inputStri = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();

	Map<String, Long> sst = Arrays.stream(spliStrings)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	// sst.forEach((key, value) -> System.out.println(key + " "+ value));

	String fcharString = sst.entrySet().stream().filter(ff -> ff.getValue() > 1).findFirst().get().toString();

	System.out.println(fcharString);

	String[] inputString2 = "java Concept Of The Day".replaceAll("\\s+", "").toLowerCase().split("");

	Map<String, Long> ttt = Arrays.stream(inputString2)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	System.out.println(ttt);

	String rrr = ttt.entrySet().stream().filter(y1 -> y1.getValue() == 1).map(r -> r.getKey()).findFirst().get()
			.toString();
	System.out.println(rrr);
	;
}
	
}
