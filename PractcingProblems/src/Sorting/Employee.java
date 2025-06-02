package Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee  {
	
	private int epmid;
	private int salary;

	public Employee(int epmid, int salary) {
		super();
		this.epmid = epmid;
		this.salary = salary;
	}

	public int getEpmid() {
		return epmid;
	}

	public void setEpmid(int epmid) {
		this.epmid = epmid;
	}


	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [epmid=" + epmid + ", salary=" + salary + "]";
	}

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(2, 2000));
		employees.add(new Employee(3, 2500));
		employees.add(new Employee(4, 1000));
		employees.add(new Employee(1, 500));
		employees.add(new Employee(5, 1500));
		// you are given list employees, then sort them desc order using their salary.
		// get highest salary of 3 and apart from top 3
		List<Employee> employees2 = employees.stream().sorted((o1, o2) -> Integer.compare(o1.getSalary(), o2.getSalary()))
				.collect(Collectors.toList());
		List<Employee> employees3 = employees.stream()
				.sorted((o1, o2) -> Integer.compare(o2.getSalary(), o1.getSalary())).limit(3)
				.collect(Collectors.toList());
		List<Employee> employees4 = employees.stream().sorted((o1, o2) -> o2.getSalary() - o1.getSalary()).skip(3)
				.collect(Collectors.toList());
		System.out.println(employees2);
		System.out.println(employees3);
		System.out.println(employees4);
	}

	

}
