package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Stud {
	
	private int studId;
	private String name;
	private int fee;
	
	
	public Stud(int studId, String name, int fee) {
		super();
		this.studId = studId;
		this.name = name;
		this.fee = fee;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Stud [studId=" + studId + ", name=" + name + ", fee=" + fee + "]";
	}
}


 class Com implements Comparator<Stud>{
	@Override
	public int compare(Stud o1, Stud o2) {
		int rusul = o1.getFee() - o2.getFee();
		if (rusul == 0) {
			return o1.getName().compareTo(o2.getName());
		}
	return rusul;
	}	 
 }

public class Compat {

	public static void main(String[] args) {
			
		List<Stud> list = new ArrayList<Stud>();
		list.add(new Stud(1, "aaa", 7000));
		list.add(new Stud(6, "bbb", 5000));
		list.add(new Stud(3, "ccc", 6000));
		list.add(new Stud(2, "ddd", 6000));
		list.add(new Stud(4, "eee", 8000));
		
		
		Collections.sort(list, new Com());
		
//		list.sort(Comparator.comparingInt( s->s.getStudId()));
//		list.sort(Comparator.comparingLong( s->s.getStudId()));
//		  System.out.println("Sorted by roll number: " + list);
//		  System.out.println("Sorted by roll number: " + list);
//		
/*		list.sort(new Com());
		for (Stud stud : list) {
		System.out.println(stud);
		}
		System.out.println("Sorting by feee using class"+list);
		*/
		
		
		
	List<Stud> list2 = 	list.stream().sorted((o1, o2) -> o2.getStudId()-o1.getStudId()).collect(Collectors.toList());
	System.out.println(list2);
	
	
	
	
	
	}

}
