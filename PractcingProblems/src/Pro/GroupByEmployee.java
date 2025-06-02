package Pro;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import Streams.Employeee;

public class GroupByEmployee {

	public static void main(String[] args) {
		
		
		
		List<Emplo> employeelist = new ArrayList<Emplo>();
		employeelist.add(new Emplo(1, "Ram", "A"));
		employeelist.add(new Emplo(2, "Jon", "B"));
		employeelist.add(new Emplo(3, "Raju", "C"));
		employeelist.add(new Emplo(4, "Suresh", "A"));
		employeelist.add(new Emplo(5, "Abrham", "B"));
		
		
	  Map<String, List<Emplo>> groupbyemployeelist =	employeelist.stream().collect(Collectors.groupingBy(t->t.getDepartment(), () -> new TreeMap<String, List<Emplo>>() , Collectors.toList()));
		
	  System.out.println(groupbyemployeelist);
	  
	/*  A -> [(id=104, name='bob', dept='A'), (id=102, name='nova', dept='A')]
			  B -> [(id=101, name='alice', dept='B'), (id=103, name='kate', dept='B')]
			  C -> [(id=100, name='randy', dept='C')]
*/
	}

}
