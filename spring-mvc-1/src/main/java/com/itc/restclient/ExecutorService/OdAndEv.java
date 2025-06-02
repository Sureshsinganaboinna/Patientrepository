package com.itc.restclient.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OdAndEv {

	private static final Object LOCK_OBJECT = new Object();
	private static int Count = 0;
	private static final int Max = 10;

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		Runnable runnable = () -> {

			while (Count <= Max) {
				synchronized (LOCK_OBJECT) {

					if (Count % 2 == 0) {
						System.out.println(Thread.currentThread().getName() + "  Even number  " + Count);
						Count++;
						LOCK_OBJECT.notify();
					}
					try {
						LOCK_OBJECT.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}

				}
				

			}

		};
		Runnable runnable2 = () -> {
			while (Count <= Max) {
			synchronized (LOCK_OBJECT) {
				if (Count <= Max) {
					System.out.println(Thread.currentThread().getName() + "  Odd number  " + Count);
					Count++;
					LOCK_OBJECT.notify();
				}
				try {
					LOCK_OBJECT.wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			}

		};
		executorService.submit(runnable);
		executorService.submit(runnable2);

	}

}
