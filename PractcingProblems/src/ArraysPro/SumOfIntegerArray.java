package ArraysPro;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class SumOfIntegerArray {

	public static void main(String[] args) {
		//  Print the sum of the integers in an integer array
	//	[2,5,9,1,6] output = 23
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your arra size");
		int arraysize = scanner.nextInt();
		
		int[] arrr = new int[arraysize];
		System.out.println("please ebter array vakues");
		
		for(int i=0; i<arraysize; i++)
		{
		           arrr[i] = scanner.nextInt();
		}
		int t = 0;
		for(int i=0; i<arraysize; i++)
		{
		           t = t+arrr[i];
		}

		System.out.println(Arrays.toString(arrr));
		System.out.println(t);
		
		
		scanner.close();

	}

}
