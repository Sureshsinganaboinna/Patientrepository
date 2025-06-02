package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class StreamAdvancedLevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = Arrays.asList(2,3,4,1,5,6,7,8,8,9,9,2,3);
		List<Integer> list1 = Arrays.asList(2,3,4,1,5,6,7,8,8,8,2,3);
	
//	list.stream().filter(s -> s>5).forEach( s -> System.out.println(s));
//	list.stream().map(s -> s*2).forEach( n -> System.out.println(n));
	         Optional<Integer> sum = list.stream().filter(s-> s>8).reduce((a,b) -> a+b);
	         
	  List<Integer>   listt =  list.stream().filter( r -> list.stream().filter(s -> s.equals(r)).count()==1).collect(Collectors.toList());
	  System.out.println(listt);
	  
	  Set<Integer> sett = new HashSet<Integer>();
	  
	  Set<Integer> dublicatevalueSet =     list.stream().filter( u -> !sett.add(u)).collect(Collectors.toSet());
		
	  System.out.println(dublicatevalueSet);
	  
	  List<Integer>   listt1 =  list.stream().filter(list1::contains).collect(Collectors.toList());
	  
	  System.out.println(listt1);
	  
		//System.out.println(sum);
	  
	  //2) Find only dublicate values from the list.
		//3) Find only unique numbers from the list.
		//4)Find unique numbers list from given list.
		//5) Merge to single stream when we have stream of collections
		//6)find frequency of words in a given string. and find greater than 2 frequency
	// 1)  How do you find frequency of each character in a string using Java 8 streams?
	 
	  String str1 = "Hello hyderabad Hoe are you";
	   Map<Character, Long>  numberofcharfrequesncyMap =  str1.chars().mapToObj(t -> (char) t).collect(Collectors.groupingBy(c -> c,
			   Collectors.counting()));
	   
	   numberofcharfrequesncyMap.forEach((key, Value) -> System.out.println(key +": "+ Value));
		
     //below 16.9
	   
	// 4 // count the number of occurence of words in given string using java 8
		
			String str = "welcome to code decode and code decode welcome code";
			
			List<String> list2 = Arrays.asList(str.split(" "));
			
		Map<String, Long>	map = list2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		Map<String, Long>  kk = list2.stream().collect(Collectors.groupingBy(n->n, Collectors.counting()));
		
	     List<String> valueSet    =	kk.entrySet().stream().filter( du-> du.getValue()>1).map( k->k.getKey()).collect(Collectors.toList());
		
			System.out.println(map);
			System.out.println(valueSet);
			
			Set<String>    ss   =     	list2.stream().filter(name -> Collections.frequency(list, name)>2).collect(Collectors.toSet());
			System.out.println(ss);

	  //below 10.1
	  //7) Given a employee list, sort employess based on their salaries in desc order.
	   //fetch top 3 salaries and get employees having less than 3rd highest salary
	   // below 11.24 
	   // Count, min, max, avarage, sum
	   List<String> words = List.of("apple", "bananagg", "cherry", "date");
	   OptionalInt   stt = words.stream().mapToInt(w ->w.length()).max();
	   int   stt1 = words.stream().mapToInt( x->x.length()).summaryStatistics().getMax();
	   
	   System.out.println(stt);
	   System.out.println(stt1);
	   
	 
	  //How to get slice of a stream in java
	   
	  List<Integer> inList = Arrays.asList(2,3,4,1,5,6,7,8,8,9,9,2,3);
	       List<Integer> listtIntegers =       inList.stream().distinct().sorted().collect(Collectors.toList());
	       List<Integer> listtIntegers1 =       listtIntegers.stream().skip(1).limit(3).collect(Collectors.toList());
	       System.out.println(listtIntegers);
	       System.out.println(listtIntegers1);
	  //Convert string to uppercase and join them with coma
	       List<String> words1 = List.of("apple", "banana", "cherry", "date");
	   String namesliString =    words1.stream().map( w -> w.toUpperCase()).collect(Collectors.joining(", "));
	   System.out.println(namesliString);
	   
	   // Collectors & groupBy clause 
	  
	    //one parameter :- internally calls two parameters like groupBy(classifier, toList)
		Map<Object, List<String>>	map1 = list2.stream().collect(Collectors.groupingBy( c->c));
		  System.out.println(map1);
		//two parameters :- internally calls three parameters like (classifier, Hashmap::new, downstream)(downstream means:- collecters in which form of data you want to get like list, set)
			Map<Object, Set<String>>	map2 = list2.stream().collect(Collectors.groupingBy( c->c, Collectors.toSet()));
	  System.out.println(map2);
	  
		List<Integer> lis = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
	    	int  evennumbers = lis.stream().filter( t -> t%2==0).mapToInt(s -> s).sum();
	      	
	       System.out.println(evennumbers);
	       
	       List<String> words5 = List.of("apple", "banana", "cherry", "date","apple", "banana","apple");
	       
	       long applecount = words5.stream().filter( s -> s.equals("apple")).count();
	       
	       System.out.println(applecount);
	      
	    Map<Object, Long> mapkeyandvaluesMap  =   words5.stream().filter( s -> s == "apple") .collect(Collectors.groupingBy( g->g, Collectors.counting()));
	  
	    mapkeyandvaluesMap.forEach((key, value) -> System.out.println(key));
	 
	}

}
