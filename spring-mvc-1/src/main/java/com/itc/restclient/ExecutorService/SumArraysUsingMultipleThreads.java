package com.itc.restclient.ExecutorService;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumArraysUsingMultipleThreads {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		Callable<Integer> halfarray = () -> {

			int sum = 0;
			for (int i = 0; i < numbers.length / 2; i++) {
				sum = sum + i;
			}

			return sum;

		};

		Callable<Integer> anotherhalf = () -> {

			int summm = 0;
			for (int i = numbers.length / 2; i < numbers.length; i++) {
				summm = summm + i;
			}
			return summm;

		};

		Future<Integer> ss = executorService.submit(halfarray);
		Future<Integer> sss = executorService.submit(anotherhalf);

		int su = ss.get() + sss.get();
		System.out.println(su);
	}

}
