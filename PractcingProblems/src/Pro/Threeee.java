package Pro;

public class Threeee extends Thread{
	


	public void run(int a, int b) {

		int c = a + b;

		System.out.println("Testing run method of runnable interface by extending thread class" + c);
	}

}
