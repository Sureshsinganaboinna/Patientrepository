package ArraysPro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class MergeTwoArrays {

	public static void main(String[] args) {
		// Merge two arrays and print the output in the console
		// input [chai, coffee] input = [milk, water, coke]
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter you array size");
		int arra1 = scanner.nextInt();
		System.out.println("please enter your array list");
		String[] arr = new String[arra1];
		for(int i=0;i<arra1; i++)
		{
			arr[i] = scanner.next();
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("please enter you array size");
		int arra2 = scanner.nextInt();
		System.out.println("please enter your array list");
		String[] arrr = new String[arra2];
		for(int i=0;i<arra2; i++)
		{
			arrr[i] = scanner.next();
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arrr));
		
	   String[] thirdarrr = new String[arr.length+arrr.length];
	   
	   for(int i=0; i<arr.length;i++)
	   {
		   thirdarrr[i] = arr[i];
	   }
	   for(int i=0; i<arrr.length;i++)
	   {
		   thirdarrr[arr.length+i] = arrr[i];
	   }
	   Arrays.sort(thirdarrr);
	   System.out.println("Merged array "+Arrays.toString(thirdarrr));
	}

}
