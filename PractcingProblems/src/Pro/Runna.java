package Pro;

public class Runna   {

	public static void main(String[] args) {

		Runnable rr = () -> {

			System.out.println("Testig runnable interface");
		};

		Thread thread = new Thread(rr);

		thread.start();

	}

}
