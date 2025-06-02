package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DublicateNumbers {

	
	// List<Integer> numbers = Arraylist.aslist(1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8);

	List<Integer> numbers1 = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8); // ArrayList<Integer> (1, 2, 2, 3, 4, 4,
																				// 5, 6, 6, 7, 8, 8);

	List<Integer> uniquenumbers = numbers1.stream().distinct().collect(Collectors.toList());

//	List<integer> uniquenumbers = numbers.stream().collect(collectros.asset);


}
