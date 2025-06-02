package StringProblems;

import java.util.Iterator;
import java.util.Scanner;


public class NumberofAccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Write a java program to count the total number of occurrences 
		
		
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("please enter your input string");
	  String string = scanner.nextLine();
	  System.out.println("please enter your target charachter");
	  char targetchar = scanner.next().charAt(0);
	  int count = 0;
	//  char[] chaaa = string.toCharArray();
	 for( int i = 0; i <string.length(); i++)
	 {
		 if(string.charAt(i)==targetchar)
		 {
		 count++;
		 }
	 }
		System.out.println("ccount : "+ count);
		
	}

}
