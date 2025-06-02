package ArraysPro;

import java.util.Iterator;
import java.util.Scanner;

public class AvarageOfInteger {

	public static void main(String[] args) {
		// Print the average of the integers in an integer array 
		// input = [2,5,3,9,6] & output = 5
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your array size");
		int arraysize = scanner.nextInt();
		System.out.println("please enter your array list");

		int[] aa = new int[arraysize];
		for (int i = 0; i < arraysize; i++) {
			aa[i] = scanner.nextInt();
		}
		int sum = 0;
		int Avarage = 0;
		for (int i = 0; i < arraysize; i++) {
			sum = sum + aa[i];
			Avarage = sum / arraysize;
		}
		System.out.println("sum " + sum);
		System.out.println("Avarage  " + Avarage);

	System.out.println("//////////////////////////////////////////////////");
		
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("please enter your array size");
		  int arrasi = scanner2.nextInt();
			System.out.println("please enter your array list");
		  int[] nn = new int[arrasi];
		  for(int n = 0; n<arrasi; n++)
		  {
			  nn [n] =   scanner2.nextInt();
		  }
		  
		  int sum1 = 0;
		  int ava = 0;
		  for(int n = 0; n <arrasi; n++)
		  {
			  sum1 = sum1 + nn [n];
			  ava = sum1/arrasi;
		  }
		System.out.println(sum1);
		System.out.println(ava);
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
