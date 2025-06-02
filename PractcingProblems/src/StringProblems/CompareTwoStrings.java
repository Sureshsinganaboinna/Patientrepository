package StringProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CompareTwoStrings {

	public static void main(String[] args) {
	//Compare two strings, if the characters in string 1 prasent in string 2 then it should be printed as such output,
	//else '+' should be printed in output (ignore case difference) input :- New york and input 2 :- NWYR output N+w+Y+r
	/*	 Scanner scanner = new Scanner(System.in);
		  System.out.println("Enter your input1 string");
		  String input1 = scanner.nextLine();
		  System.out.println("Enter your input2 string");
		  String input2 = scanner.nextLine();
		  String output = "";
		  for(int i=0; i<input1.length();i++)
		  {
			  char ch = input1.toLowerCase().charAt(i);
			  if(input2.toLowerCase().indexOf(ch)>=0)
			  {
				  output += input1.charAt(i);
			  }
			  else {
				  output += "+";
			}
		  }
		System.out.println(output);*/
		
	String input1 = "Suresh ramesh ram rejesh jan ja";

	String[] spliStrings = input1.split(" ");

	String maxlenString = spliStrings[0];

	List<String> strings = new ArrayList<String>();

	for (int i = 0; i < spliStrings.length; i++) {

		if (maxlenString.length() <= spliStrings[i].length()) {
			maxlenString = spliStrings[i];
			strings.add(maxlenString);
		}

	}
	System.out.println(strings);

}

}
