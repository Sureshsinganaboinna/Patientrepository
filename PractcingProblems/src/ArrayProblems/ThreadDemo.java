package ArrayProblems;

public class ThreadDemo {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.start();
		
		
		Emp emp = new Emp();
		Thread thread = new Thread(emp);
		
        thread.start();
	}

}
