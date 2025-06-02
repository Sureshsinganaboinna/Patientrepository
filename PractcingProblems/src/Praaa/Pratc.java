package Praaa;

import java.util.Arrays;
import java.util.List;

public class Pratc {

	public static void main(String[] args) {

		
		String str = "HelloWorld";
		
		System.out.println(str.substring(5));
		
		System.out.println(str.substring(0, 5));
		System.out.println(str.indexOf("H"));
		
		System.out.println(str.lastIndexOf("World"));
		System.out.println(str.replace('l', 's'));
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// Sequential Stream
		list.stream().forEach(System.out::println);

		// Parallel Stream
		list.parallelStream().forEach(System.out::println);
     
		
		//parallel stream process the data concurenlty using multi threads for faster execution 
		
		
		
	}

}
