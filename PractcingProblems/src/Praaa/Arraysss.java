package Praaa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Arraysss {

	public static void main(String[] args) {

		
	//	int[] a = {1,1,2,2,5,6,4};
		
	List<Integer> ss = Arrays.asList(1, 1, 2, 2, 5, 6, 4);

	List<Integer> uniqunumbers = ss.stream().distinct().sorted().collect(Collectors.toList());

	System.out.println(uniqunumbers);

	}

}
