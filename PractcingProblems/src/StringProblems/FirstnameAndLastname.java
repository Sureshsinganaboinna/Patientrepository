package StringProblems;

import java.util.Scanner;

public class FirstnameAndLastname {

	public static void main(String[] args) {
		// Given first and lastnames, then print last followed by "." and first latter
		// of firstname
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your input1 string");
		String input1 = scanner.nextLine();
		System.out.println("Enter your input2 string");
		String input2 = scanner.nextLine();
		System.out.println(input2 + "." + input1.charAt(0));
	}

}
