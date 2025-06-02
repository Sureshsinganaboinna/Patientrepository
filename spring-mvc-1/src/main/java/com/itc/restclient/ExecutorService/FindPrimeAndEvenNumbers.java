package com.itc.restclient.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FindPrimeAndEvenNumbers {

	private static final Object lockobject = new Object(); 
//	private static final Object lockobject1 = new Object();// Ensures all threads use the same lock object. Prevents
															// accidental reassignment.
	private static int Count = 0;
	private static final int Max = 10;

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		Runnable prinevennumbers = () -> {

			while (Count <= Max) {
				synchronized (lockobject) {
					if (Count % 2 == 0) {
						System.out.println(Thread.currentThread().getName() + "- Even :" + Count);
						Count++;
						lockobject.notify();
					}
					try {
						lockobject.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}

			}

		};

		Runnable printOddNumbers = () -> {

			while (Count <= Max) {
				synchronized (lockobject) {

					if (Count % 2 != 0) {
						System.out.println(Thread.currentThread().getName() + "- Odd :" + Count);
						Count++;
						lockobject.notify();
					}
					try {
						lockobject.wait();
					} catch (Exception e) {
						Thread.currentThread().interrupt();
					}
				}
			}

		};
		executor.submit(prinevennumbers);
		executor.submit(printOddNumbers);

		executor.shutdown();

	}

}
