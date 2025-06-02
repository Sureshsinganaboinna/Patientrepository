package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsCoding {

	public static void main(String[] args) {
		
		String string = "welcome to code decode and decode code";
		
	    
		List<String> countaccurencesofwordsingvenString =  Arrays.asList(string.split(" "));
		//List<String> countaccurencesofwordsingvenString1 = new ArrayList<String>();
		//countaccurencesofwordsingvenString1.add("welcome to code decode and decode code");
	   Map<String, Long> numberofoccurence =	countaccurencesofwordsingvenString.stream()
		                                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(numberofoccurence);
		
		//find the dublicate elements in a given integer list in java using stream function.
		                               
		     List<Integer> list = Arrays.asList(10,28,87,10,76,20,28,80);
		     Set<Integer> settIntegers = new HashSet<Integer>();
		     Set<Integer> listtIntegers1 =     list.stream()
		    		                                .filter( s -> !settIntegers.add(s))
		    		                                .collect(Collectors.toSet());
		     System.out.println(listtIntegers1);
	// write a program to multiplay 2 no's using functional interface.
		     // Limit() :- it is a intermediate operater. as soon as limit() method reaches the maximum size of elements then rest of the 
		     //elements does not consume by limit. those will get short circute.
		     //skipe :- it is intermediate operater it discards the first n elements, n pararmeters can not be nagative. if it's higher then
		     //size of stream then skip() method returns an empty stream.
		     
		     
		     // Find unique values from an array
		     List<Integer> uniqueelements = Arrays.asList(10,28,87,10,76,20,28,80);
		               List<Integer>  uninumberfromList = uniqueelements.stream()
		                                                   .filter( n -> uniqueelements.stream().filter( s -> s.equals(n)).count()==1)
		                                                   .collect(Collectors.toList());
		     System.out.println(uninumberfromList);
	
		
	}

}
