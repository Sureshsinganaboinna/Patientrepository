package com.itc.restclient.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintNumbers1to10 {
	
	
	

	public static void main(String[] args) {

	ExecutorService executorService = Executors.newFixedThreadPool(2);
	
	
	 Runnable runnable = () -> {
		 
		 for(int i=0; i<=10; i++)
		 {
			 System.out.println(Thread.currentThread().getName()+" printing numbers using threads "+ i);
		 }
		 
	 };
	                      
	 executorService.submit(runnable);
		
		
		
	}

}
