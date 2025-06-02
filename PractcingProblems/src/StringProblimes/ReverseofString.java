package StringProblimes;

import java.util.Scanner;

public class ReverseofString {

	public static void main(String[] args) {
		// Write a java program to reverse a string
       // input = java is super, output = repus si avaj
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your string");
		String str = scanner.nextLine();
		String revString = "";
		for(int i=str.length()-1;  i>=0 ;i--)
		{
			revString = revString + str.charAt(i);
		}
		System.out.println("revString is :- "+revString);
	}

}
