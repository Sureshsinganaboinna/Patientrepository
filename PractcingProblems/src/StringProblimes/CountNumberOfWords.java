package StringProblimes;

import java.util.Scanner;

public class CountNumberOfWords {

	public static void main(String[] args) {
		//  Write a java program to count the number of words in a string
		// input = java is super output = 3
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your string");
		String str = scanner.nextLine();
		System.out.println("Entered String:- " + str.length());
		String[] strarr = str.split(" ");
		System.out.println("number of words in a string : " + strarr.length);
		
		
	}

}
