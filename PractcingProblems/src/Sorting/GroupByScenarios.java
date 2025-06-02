package Sorting;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupByScenarios {

	private int id;
	private String name;
	private int age;

	public GroupByScenarios(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupByScenarios other = (GroupByScenarios) obj;
		return Objects.equals(name, other.name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "GroupByScenarios [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		// create a map with Key as Age and values as a list of employees in that age group
		//grouping collecters uses a classifier funciton<T,K>   //T= type of object in stream and // K are the "group names" or group keys

		List<GroupByScenarios> groupByScenarios = new ArrayList<GroupByScenarios>();
		groupByScenarios.add(new GroupByScenarios(1, "Su", 25));
		groupByScenarios.add(new GroupByScenarios(2, "Su", 25));
		groupByScenarios.add(new GroupByScenarios(4, "Ta", 20));
		groupByScenarios.add(new GroupByScenarios(3, "Ja", 23));
		groupByScenarios.add(new GroupByScenarios(8, "Ua", 25));
		
		// create a map with Key as Age and values as a list of employees in that age
		// group
		Map<Integer, Set<GroupByScenarios>> groupedbyageemployeeByScenarios = groupByScenarios.stream()
				.collect(Collectors.groupingBy(s -> s.getAge(), Collectors.toSet()));
		Map<Integer, Set<GroupByScenarios>> groupedbyageemployeeByScenarios2 = groupByScenarios.stream()
				.collect(Collectors.groupingBy(s -> s.getAge(), TreeMap::new, Collectors.toSet()));
		// group by age with unique names
		Map<Integer, List<GroupByScenarios>> groupedbyageemployeeByScenarios1 = groupByScenarios.stream()
				.collect(Collectors.groupingBy(s -> s.getAge()));
		System.out.println(groupedbyageemployeeByScenarios);
		System.out.println(groupedbyageemployeeByScenarios1); 
		System.out.println(groupedbyageemployeeByScenarios2);
//===========================================================================================================================================		

		// find min, max,count, avarage and sum of age

		List<Integer> ages = groupByScenarios.stream().map(x -> x.getAge()).collect(Collectors.toList());
		int minage = ages.stream().mapToInt(t -> t).summaryStatistics().getMin();

		int maxage = ages.stream().mapToInt(t -> t).summaryStatistics().getMax();
		ages.stream().mapToInt(t->t).average();
		long sumage = ages.stream().mapToInt(t -> t).summaryStatistics().getSum();
		double avgage = ages.stream().mapToInt(t -> t).summaryStatistics().getAverage();
		long countage = ages.stream().mapToInt(t -> t).summaryStatistics().getCount();
		System.out.println(minage);
		System.out.println(maxage);
		System.out.println(sumage);
		System.out.println(avgage);
		System.out.println(countage);
		
 //============================================================================================================================================     
      //converting given string to uppercase and join them with coma
      //Given an employeee table fetch the employee object with id and return the name in uppercase and collect all of them using ,
      
	String combinenamefromStringemployee = groupByScenarios.stream().map(u -> u.getName().toUpperCase())
			.collect(Collectors.joining(",","[","]"));
	System.out.println(combinenamefromStringemployee);
		
		//find the first element of  a stream using reduce() method in java 
		
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

		Optional<String> findfirst = names.stream().reduce((first, second) -> first);

		findfirst.ifPresent(findf -> System.out.println(findf));
		
		// When you only need the first element: Use findFirst()—it’s simpler and
		// purpose-built.
		// When you need extra processing on the first element or need to apply custom
		// aggregation logic: Use reduce().
		List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie");

		// Using reduce() with additional logic
		Optional<String> firstElementUpper = names1.stream().reduce((first, second) -> first.toUpperCase());

		// Output: ALICE
		firstElementUpper.ifPresent(System.out::println);
		
		List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
	int ss2 =	numbers.stream().filter(t->t>5).map(t->t*2).findFirst().get();
	System.out.println(ss2);
		// Using reduce() with additional logic
		Optional<Integer> firstDoubled = numbers.stream()
		                                        .filter(n -> n > 5)
		                                        .reduce((first, second) -> first * 2);
		// Output: 12 (6 is the first > 5, and it's doubled)
		firstDoubled.ifPresent(System.out::println);
		// count occurence of a given characheter in a string using stream API
		String str = "welcometomonocept";
		List<String> ssCharacters = Arrays.asList(str.split(""));
		Long ttLong = ssCharacters.stream().filter(r -> r.equals(String.valueOf('o'))).count();
		System.out.println(ttLong);
		Long ttLong1 = ssCharacters.stream().filter(t -> t.charAt(0) == 'o').count();
		System.out.println(ttLong1);
		long ttLong2 = str.chars().filter(r -> r == 'o').count();
		str.chars().mapToObj(y -> (char) y).filter(y -> y == 'o').count();
		System.out.println(ttLong2);
		// How to get Arraylist from stream
		List<String> names11 = Arrays.asList("Alice", "Bob", "Charlie");
		ArrayList<String> ss = names11.stream().collect(Collectors.toCollection(() -> new ArrayList<String>()));
		System.out.println(ss);
	 
		
		
	}

}
