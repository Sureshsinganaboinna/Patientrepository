package ArraysPro;

import java.util.Scanner;

public class SecondLargestNumber {

	public static void main(String[] args) {
		// Second largest number
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your arra size");
		int arraysize = scanner.nextInt();
		int[] arrr = new int[arraysize];
		System.out.println("please ebter array vakues");
		for (int i = 0; i < arraysize; i++) {
			arrr[i] = scanner.nextInt();
		}
		int max = arrr[0];
		int secondMax = Integer.MIN_VALUE;
		int index = 0;
		for (int i = 0; i < arrr.length; i++) {
			if (arrr[i] > max) {
				secondMax = max;
				max = arrr[i];
				index = i;
			} else if (arrr[i] < max && secondMax < arrr[i]) {
				secondMax = arrr[i];
			}
		}
		System.out.println("Max number of array: " + max);
		System.out.println("Second max number of array: " + secondMax);
		System.out.println("Max number index: " + index);

	}

}
