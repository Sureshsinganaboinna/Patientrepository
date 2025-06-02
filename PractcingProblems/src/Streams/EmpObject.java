package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmpObject {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1, 500));
		list.add(new Employee(2, 1000));
		list.add(new Employee(3, 1500));
		list.add(new Employee(4, 2000));
		list.add(new Employee(5, 2500));
		list.add(new Employee(6, 3000));
		list.add(new Employee(7, 3500));
		
		List<Employee> listt = list.stream().sorted((o1, o2) -> (int) (o1.getSalary()-o2.getSalary())).skip(3)
				.collect(Collectors.toList());
		System.out.println(listt);

		List<Employee> listt1 = list.stream().sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()))
				.collect(Collectors.toList());
		System.out.println(listt1);

		String string = "Java i Java U Java".replaceAll("\s+", "").toLowerCase();

		Map<String, Long> sst = Arrays.stream(string.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		String string2 = sst.entrySet().stream().filter(t -> t.getValue() == 1).map(r -> r.getKey()).findFirst().get();

		System.out.println(string2);
		 
		 
		 
		                                                         
	}

}
