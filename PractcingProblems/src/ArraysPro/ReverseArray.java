package ArraysPro;

import java.util.Arrays;

import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		// Reverse the array and print it in console
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your arra size");
		int arraysize = scanner.nextInt();

		int[] arrr = new int[arraysize];
		System.out.println("please ebter array vakues");

		for (int i = 0; i < arraysize; i++) {
			arrr[i] = scanner.nextInt();
		}
		int[] revarrr = new int[arrr.length];

		for (int i = 0; i < arrr.length; i++) {
			revarrr[arrr.length - 1 - i] = arrr[i];
		}
		System.out.println("Reverse length array " + Arrays.toString(revarrr));
		scanner.close();
	}

}
