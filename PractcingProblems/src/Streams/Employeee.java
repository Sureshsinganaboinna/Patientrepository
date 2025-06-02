package Streams;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Employeee {
	
	
	private int id;
	private String name;
	private int salary;
	
	public Employeee(int id, String name, int salary)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
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


	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


	public void setid(int id)
	{
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "Employeee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public static void main(String[] args) {
		ArrayList<Employeee> employeees = new ArrayList<Employeee>();
		employeees.add(new Employeee(1, "aa", 50000));
		employeees.add(new Employeee(2, "bbb", 40000));
		employeees.add(new Employeee(3, "bbb", 30000));
		employeees.add(new Employeee(4, "dd", 20000));
		employeees.add(new Employeee(5, "ee", 10000));

		List<Employeee> eme = employeees.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
				.collect(Collectors.toList());
		eme.stream().forEach(tt -> System.out.println(tt));

	}

}
