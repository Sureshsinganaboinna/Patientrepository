package ArraysPro;

import java.util.Scanner;

public class MaxnumberFromArray {

	public static void main(String[] args) {
		// Find the max number from an array and print it along with its index
		// [2,5,9,1,6], value = 9, index = 2
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your arra size");
		int arraysize = scanner.nextInt();

		int[] arrr = new int[arraysize];
		System.out.println("please ebter array vakues");

		for (int i = 0; i < arraysize; i++) {
			arrr[i] = scanner.nextInt();
		}

		int max = arrr[0];
		int ind = 0;
		for (int i = 0; i < arrr.length; i++) {
			if (arrr[i] > max) {
				max = arrr[i];
				ind = i;
			}

		}
		System.out.println("Max number of array index " + ind);
		System.out.println("Max number from array " + max);

	}

}
