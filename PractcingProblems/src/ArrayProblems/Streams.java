package ArrayProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		 // sum of values
		  Optional<Integer> sum = list.stream().reduce((a,b) -> a+b);
		  System.out.println(sum.get());
		 

		
		 // avg of values Double
		Double   avg = list.stream().mapToInt(a ->a).average().getAsDouble();
		   System.out.println(avg);
		 

		
		//  avg after filter values 
		  List<Integer> list2 = Arrays.asList(10, 20, 30, 40,50); 
		 Double avgDouble = list2.stream().map(e -> e*e).filter(e -> e>500).mapToInt(e -> e).average().getAsDouble(); System.out.println(avgDouble);
		 
		
	
		  List<Integer> list21 = Arrays.asList(1, 2, 3, 4, 5,6,7,8); List<Integer>
		  evenIntegers = list21.stream().filter(e -> e%2 ==0).collect(Collectors.toList()); System.out.println(evenIntegers);
		  List<Integer> oddIntegers = list21.stream().filter(e -> e%2!=0).collect(Collectors.toList()); System.out.println(oddIntegers);
		 
           
		
		//print numbers starts with prefix 2
		List<Integer> list1 = Arrays.asList(1, 222, 23, 224, 55,122,322);
	      List<Integer>   valuesIntegers =	list1.stream().map(e -> String.valueOf(e)).filter(e -> e.startsWith("2")).map(e ->Integer.valueOf(e))
	    		  .collect(Collectors.toList());
		System.out.println(valuesIntegers);
		
		//print duplicate numbers
		
		List<Integer> list11 = Arrays.asList(1, 2,2,3,1,2,5,4,6,5,4);
	      Set<Integer>duplicate = list11.stream().filter(e -> Collections.frequency(list, e)>1).collect(Collectors.toSet());
	      System.out.println(duplicate);
		
		
		
		
		
		

	}

}
