package Pro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolUsingExecutorService {
	
	private static final Object LOCK_OBJECT = new Object();
	private static int Count = 0;
	private static int Max = 10;

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		Runnable evennumber = () -> {

			while (Count < Max) {
				synchronized (LOCK_OBJECT) {

					if (Count % 2 == 0) {
						System.out.println(Thread.currentThread().getName() + "Even number is" + Count);
						Count++;
						LOCK_OBJECT.notify();
					}
					try {
						LOCK_OBJECT.wait();
					} catch (Exception e) {
						Thread.currentThread().interrupt();
					}
				}

			}

		};
		Runnable oddnumbers = () -> {

			while (Count < Max) {
				synchronized (LOCK_OBJECT) {
					if (Count % 2 != 0) {
						System.out.println(Thread.currentThread().getName() + "Odd number is " + Count);
						Count++;
						LOCK_OBJECT.notify();
					}
					try {
						LOCK_OBJECT.wait();
					} catch (Exception e) {
						Thread.currentThread().interrupt();
					}

				}
			}

		};

		executorService.submit(evennumber);
		executorService.submit(oddnumbers);

	}

}
