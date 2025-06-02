package StringProblimes;

import java.util.Scanner;

public class CountNumberOfCharachers {

	public static void main(String[] args) {
		// Write a java program to count the number of characters in a string
		// input = java is super output = 13
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your string");
		String str = scanner.next();
		System.out.println("Entered String:- " + str.length());
	}

}
