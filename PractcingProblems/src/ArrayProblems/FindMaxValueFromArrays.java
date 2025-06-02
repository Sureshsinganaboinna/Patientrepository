package ArrayProblems;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxValueFromArrays {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter array size");
		int arraysize = scanner.nextInt();
		int[] array = new int[arraysize];
		System.out.println("please enter array values");
		
		for(int i=0; i<arraysize; i++)
		{
			array[i] = scanner.nextInt();
		}
		System.out.println("entered array values "+ Arrays.toString(array));
		int maxvalue = Integer.MIN_VALUE;
		int secondmaxvalue = array[1];
		int index = 0;
		for(int i=0; i<array.length; i++)
		{
			if(maxvalue<array[i])  //[2,3,4]
			{
				secondmaxvalue = maxvalue;  
				maxvalue = array[i];
				index = i;
			}   
			else if(array[i] >secondmaxvalue &&  array[i]<maxvalue)
			{
				secondmaxvalue = array[i];
			}
		}
		System.out.println("Max value from array "+ maxvalue);
		System.out.println("Second Max value from array "+ secondmaxvalue);

	}

}
