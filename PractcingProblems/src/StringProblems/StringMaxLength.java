package StringProblems;

import java.util.Scanner;

public class StringMaxLength {

	public static void main(String[] args) {
		//find max length of given string (if two words length same then return first occuring length word)
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your input string");
		String input = scanner.nextLine();
		String tempSize = " ";
		System.out.println(tempSize.length());
		String[] wordS = input.split(" ");
		for (int i = 0; i < wordS.length; i++) {
			String eachword = wordS[i];
			if (eachword.length() > tempSize.length()) {

				tempSize = eachword;
			}
		}
		System.out.println(tempSize);
	}

}
