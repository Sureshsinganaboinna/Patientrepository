package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

import javax.security.auth.x500.X500Principal;

public class Arraays {

	public static void main(String[] args) {
		// Given an array of integers, write a java 8 program to find second smallest number

		int[] numbers = { 5, 2, 8, 3, 1, 1, 2 };

		int secondsmaalest = Arrays.stream(numbers).distinct().sorted().skip(1).findFirst().getAsInt();

		System.out.println(secondsmaalest);
		
		// Given two arrays of integers, write a java 8 programe to find a common element between them
		
		int[] num = {1,2,3,4,5};
		int[] nu = {4,5,6,7,8};
		
	List<Integer> commonelemtns	= Arrays.stream(num).filter(n -> Arrays.stream(nu).anyMatch(s-> s == n)).boxed().collect(Collectors.toList());
	
	List<int[]> ssIntegers = Arrays.asList(num);
	List<int[]> ssIntegers1 = Arrays.asList(nu);
	
	
	List<int[]> ss = ssIntegers.stream().filter(u ->ssIntegers1.contains(u) ).collect(Collectors.toList());
	
	System.out.println(ss);
		
	System.out.println(commonelemtns);
	
	
	String str = "WELCOME";

	String[] strrr = str.split("");

	Set<String> set = new HashSet<String>();

	String ssString = Arrays.stream(strrr).distinct().collect(Collectors.joining()).toString();

	System.out.println(ssString);
	
	
	
	
	
	
	
	
	
	
	
	
             
	}

}
