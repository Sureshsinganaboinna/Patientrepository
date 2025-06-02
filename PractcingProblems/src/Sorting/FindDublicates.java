package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.jar.Attributes.Name;
import java.util.stream.Collectors;

public class FindDublicates {

	public static void main(String[] args) {
   // How to find dublicate elements in a stream in java
	List<String> str = Arrays.asList("abd", "abc", "ab", "bc", "abc", "ab");

	Set<String> hashSe = new HashSet<String>();

	Set<String> ss1 = str.stream().filter(s -> !hashSe.add(s)).collect(Collectors.toSet());
	
	Map<String, Long> duMap = str.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	Set<String> ssSet = duMap.entrySet().stream().filter(s -> s.getValue() > 1).map(en -> en.getKey())
			.collect(Collectors.toSet());
	     
	Set<String> ssssStrings = str.stream().filter(name -> Collections.frequency(str, name) > 1)
			.collect(Collectors.toSet());

	// Set<String> ss = str.stream().filter( s ->
	// hashSe.add(s)).collect(Collectors.toSet());
	// System.out.println(ss);
	System.out.println(ss1);
	System.out.println(ssSet);
	System.out.println(ssssStrings);

	}

}
