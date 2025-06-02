package ArrayProblems;

import java.util.Comparator;

public class User  {
	
	private int id;
	
	private int salary;
	private String name;
	
	
	
	public User(int id, int salary, String name) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	@Override
//	public int compareTo(User o) {
//	
//		return this.getSalary() - o.getSalary();
//	}
	@Override
	public String toString() {
		return "User [id=" + id + ", salary=" + salary + ", name=" + name + "]";
	}
	
	
	
	static class Usss implements Comparator<User>{

		@Override
		public int compare(User o1, User o2) {
			int nn = o2.getSalary() - o1.getSalary();
			if(nn == 0)
			{
				return o2.getName().compareTo(o1.getName());
			}
			return nn;
		}
		
	}
	
	

}
