package Streams;





import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;






public class PracticeStreams {

	public static void main(String[] args) {
		// Verify that given string is palindrom or not.

		String str = "ROTATOR";

		boolean Ispalindram = IntStream.range(0, str.length() / 2)
				.noneMatch(w -> str.charAt(w) != str.charAt(str.length() - w - 1));
		if (Ispalindram) {
			System.out.println("Given string is palindrom");
		} else {
			System.out.println("Given string is not palindrom");
		}
		
		// 27) Find first repeated character in a string?
		 
		 String inputStri = "Java Concept Of The Day".replaceAll("\\s+","").toLowerCase();
		 System.out.println(inputStri);
		 String[] ssssStrings = inputStri.split("");
		 
		 List<String> llList = Arrays.asList(ssssStrings);
		 
		// System.out.println(Arrays.toString(ssssStrings));
		
	     Map<String, Long>  cc =	llList.stream() .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 
	      cc.entrySet().stream().forEach(qq->System.out.println(qq));
	     
   String ssString =   cc.entrySet().stream().filter( s -> s.getValue()>1).map( r -> r.getKey()).findAny().get();
		
		 System.out.println(ssString);
		 
			//26) Print duplicate characters in a string?
		 String iString = "Java Concept Of The Day".replaceAll("\\s+","").toLowerCase();
		 
		 Set<String> settSet = new HashSet<String>();
		 
		Set<String>  tt =   Arrays.stream(iString.split("")).filter( ss -> !settSet.add(ss)).collect(Collectors.toSet());
		   
		System.out.println(tt);
		
		
 //   24) Given a list of strings, find out those strings which start with a number?
	    
	    List<String> listOfString = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
	    
	  List<String> vv = listOfString.stream().filter( ll -> Character.isDigit(ll.charAt(0))).collect(Collectors.toList());
	    System.out.println(vv);
	    
	    
	       //  22) How do you find the most repeated element in an array?
	         
	         List<String> listOfStrings3 = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
	     Map<String, Long> keypaMap =   listOfStrings3.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	 Entry<String, Long>  ssMap =    keypaMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
	 
	 System.out.println(ssMap.getValue());
	 System.out.println(ssMap.getKey());
	 
     //Print first 10 even numbers
     IntStream.rangeClosed(1, 10).map(i2 -> i2 * 2).forEach(System.out::println);
     IntStream.rangeClosed(1, 10).map( zz -> zz*2).forEach(System.out::println);
     
     //  20) Reverse an integer array
     
     int[] array = new int[] {5, 1, 7, 3, 9, 6};
     int[] reverearray  =  IntStream.rangeClosed(0, array.length-1).map( c -> array[array.length-1-c]).toArray();
	     
     System.out.println(Arrays.toString(reverearray));
     
     // 18) Reverse each word of a string using Java 8 streams?
     
     String strr = "Java Concept Of The Day";
     String[] ssStrings2 = strr.split(" ");
     
     List<String> ssStrings3 = Arrays.asList(ssStrings2);
      String  reverseword =  ssStrings3.stream().map( f -> new StringBuffer(f).reverse()).collect(Collectors.joining(" ")).toString();
      System.out.println(reverseword);
      //17) How do you find common elements between two arrays?
      
      List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
      List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
      
   List<Integer> llIntegers  =  list1.stream().filter(list -> list2.contains(list)).collect(Collectors.toList());
      
          System.out.println(llIntegers);
          
      	//15) Given a list of strings, sort them according to increasing order of their length?
  		List<String> listOfStrings2 = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
  		   
	}
	
	

}
