package Singletondesignpattern;

public class SingletonPractice {

	private static SingletonPractice instancePractice;

	private SingletonPractice() {

	}

	public static SingletonPractice getinstancePractice() {

		if (instancePractice == null) {
			synchronized (SingletonPractice.class) {
				if (instancePractice == null) {
					instancePractice = new SingletonPractice();
				}
			}

		}
		return instancePractice;
	}

}
