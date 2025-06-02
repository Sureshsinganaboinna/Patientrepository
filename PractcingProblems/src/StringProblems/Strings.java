package StringProblems;

import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your String value");
		String input = sc.nextLine();
		//count number of charachters in string
		System.out.println("find input string legnth: " + input.length());
		
		//count the number of occurenece of given a charachter in string
		//count number of words in given a string
		int count = 0;
		String[] wordS = input.split(" ");
		System.out.println("Number of words in given String: " + wordS.length);
		for (int i = 0; i < wordS.length; i++) {
			count++;
		}
		System.out.println("Number of words in given String: " + count);
		
		//////////////////////////////////////////
		
		String reverseString = new String();
		for(int j = input.length()-1; j>=0; j--)
		{
			reverseString = reverseString + input.charAt(j);
		}
		// reverse string
		System.out.println("Reverse String is: "+reverseString);
		
		//////////////////////////////
		String reverseWord = " ";
		for(int k = 0; k< wordS.length; k++)
		{
			String word = wordS[k];
			for(int m = word.length()-1; m>=0; m--)
			{
				reverseWord  +=  word.charAt(m);
				
			}
			if(k!=word.length()-1)
			{
			reverseWord += " ";
			}
		}
		//reverse of each of of string
		System.out.println("Reverse of each word:-"+reverseWord );
	}
//	Write a java program to count the number of characters in a string
//	❇️ Write a java program to count the number of words in a string
//	❇️ Write a java program to count the total number of occurrences 
//	of a given character in a string
//	❇️ Write a java program to reverse a string
//	❇️ Write a java program to remove all starting and ending spaces from a string
//	❇️ Write a java program to reverse each word of a given string
//	❇️ Write a java program to modify the string in the mentioned pattern
//	❇️ Write a java program to find the count of uppercase letters, lowercase letters, digits and special characters in a given string
//	❇️ Write a java program to find the first repeated and non-repeated character in the given string
//	❇️ Write a java program to create an array using words at odd positions in a string
//	❇️ Write a java program to find the max length-word in a given string 
//	Compare two strings, if the characters in string 1 are present in string 2, then it should be printed as such in output, else '+' should be printed in output 
//	❇️ Given the first name and last name, print the last name first then followed by "," and first character of the first name
//	❇️ Write a java program to print the filename extension in the console
//	❇️ Write a java program to verify whether the given string is palindrome or not

}
