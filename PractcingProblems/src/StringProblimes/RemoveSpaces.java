package StringProblimes;

import java.util.Scanner;

public class RemoveSpaces {

	public static void main(String[] args) {
		// Write a java program to remove all starting and ending spaces from a string
		//input =      Hello World  output = Hello world
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your string");
		String str = scanner.nextLine();
		System.out.println("Entered String:- " + str.trim());
	}

}
