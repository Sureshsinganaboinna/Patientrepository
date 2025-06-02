package Sorting;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Employeee {
    private int id;
    private String name;

    public Employeee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employeee [id=" + id + ", name=" + name + "]";
    }
}

public class Emp {
    public static void main(String[] args) {
        List<Employeee> employees = Arrays.asList(
                new Employeee(2, "Suresh"),
                new Employeee(1, "Arun"),
                new Employeee(3, "Mahesh"),
                new Employeee(3, "Mahi"),
                new Employeee(4, "Ram"),
                new Employeee(4, "mmm")
        );
        
//        Comparator<Employeee>  comparator = new Comparator<Employeee>() {
//			
//			@Override
//			public int compare(Employeee o1, Employeee o2) {
//				
//				return o2.getName().compareTo(o1.getName());
//			}
//		};     
        
       // Comparator<Employeee> comparator = (Employeee e1, Employeee e2) -> e2.getName().compareTo(e1.getName());
        
		Comparator<Employeee> comparator = (Employeee e1, Employeee e2) -> {

			int result = e2.getId() - e1.getId();

			if (result == 0) {
				e2.getName().compareTo(e2.getName());
			}
			return result;
		};
        
	List<Employeee>    ssEmployeees =	employees.stream().sorted( (Employeee e1, Employeee e2) -> {

		int result = e2.getId() - e1.getId();

		if (result == 0) {
			e2.getName().compareTo(e2.getName());
		}
		return result;
	} ).collect(Collectors.toList());
	
	System.out.println(ssEmployeees);
	
	
	}
				
		
		
		
		/*
		Collections.sort(employees,comparator );
		
		for (Employeee employeee : employees) {
			
			System.out.println(employeee);
			
		}
*/
    }

