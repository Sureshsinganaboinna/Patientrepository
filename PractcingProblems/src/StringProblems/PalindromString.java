package StringProblems;

import java.util.Scanner;

public class PalindromString {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		  System.out.println("Enter your input string");
		  String input = scanner.nextLine();
		  String temp = input;
		  String revString = "";
		  for(int i=input.length()-1;i>=0;i--)
		  {
			  revString += input.charAt(i);
		  }
		  System.out.println(revString);
		if(revString.equals(temp)) {
			System.out.println("Given String is a palindrom "+ revString);
		}else {
			System.out.println("Given String is not a palindrome");
		}

	}

}
