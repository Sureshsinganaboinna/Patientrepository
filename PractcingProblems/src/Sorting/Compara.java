package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Student implements Comparable<Student> {
	
	private int rollnumber;
	private String name;
	
	
	public Student(int rollnumber, String name) {
		super();
		this.rollnumber = rollnumber;
		this.name = name;
	}
	public int getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [rollnumber=" + rollnumber + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Student o) {
		
		return o.getRollnumber() - this.getRollnumber();
	}
	
}

public class Compara {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "suresh"));
		students.add(new Student(4, "ram"));
		students.add(new Student(5, "jon"));
		students.add(new Student(3, "Aon"));
		
		
		students.stream().sorted().collect(Collectors.toList()).forEach( k -> System.out.println(k));
	//	Collections.sort(students);
	
//	
//		for (Student student : students) {
//			System.out.println(student);
//		}
	}
	
	

	
	
	

}
