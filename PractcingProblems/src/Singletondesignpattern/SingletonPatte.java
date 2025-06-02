package Singletondesignpattern;

public class SingletonPatte {

	public static void main(String[] args) {
	
		// SingletonPractice insPractice = SingletonPractice.getinstancePractice();

		Runnable task = () -> {

			SingletonPractice insPractice = SingletonPractice.getinstancePractice();
			System.out.println(insPractice);

		};

		Thread thread = new Thread(task);
		thread.start();
		Thread thread2 = new Thread(task);
		thread2.start();

	}

}
