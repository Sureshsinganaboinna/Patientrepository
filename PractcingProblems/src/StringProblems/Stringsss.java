package StringProblems;

import java.text.StringCharacterIterator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Stringsss {

	public static void main(String[] args) {
		
		
		
		//❇️ Write a java program to count the total number of occurrences of a given character in a string
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your input");
		String str = scanner.nextLine();
		char tragetcha = 'a';
		int count = 0;
		for (int i = 0; i < str.length(); i++) {

			char strchar = str.charAt(i);

			if (strchar == tragetcha) {

				count++;

			}

		}
		System.out.println("number of occurenece " + count);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Write a java program to count the number of characters in a string
//		❇️ Write a java program to count the number of words in a string
//		❇️ Write a java program to count the total number of occurrences 
//		of a given character in a string
//		❇️ Write a java program to reverse a string
//		❇️ Write a java program to remove all starting and ending spaces from a string
//		❇️ Write a java program to reverse each word of a given string
//		❇️ Write a java program to modify the string in the mentioned pattern
//		❇️ Write a java program to find the count of uppercase letters, lowercase letters, digits and special characters in a given string
//		❇️ Write a java program to find the first repeated and non-repeated character in the given string
//		❇️ Write a java program to create an array using words at odd positions in a string
//		❇️ Write a java program to find the max length-word in a given string 
//		Compare two strings, if the characters in string 1 are present in string 2, then it should be printed as such in output, else '+' should be printed in output 
//		❇️ Given the first name and last name, print the last name first then followed by "," and first character of the first name
//		❇️ Write a java program to print the filename extension in the console
//		❇️ Write a java program to verify whether the given string is palindrome or not
	}

}
