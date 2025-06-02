package StringProblimes;

import java.util.Scanner;

public class CountNumberofOccurences {

	public static void main(String[] args) {
		// Write a java program to count the total number of occurrences 
		//of a given character in a string
		// input = Hello World , target input = l output = 3
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your string");
		String str = scanner.nextLine();
		System.out.println("please enter your targetchar ");
		char targetchar = 'l';
		int Count = 0;
		for(int i = 0; i<str.length();i++)
		{
			if(targetchar == str.charAt(i))
			{
				Count++;
			}
		}
		System.out.println("number of occureneces of given charachter :- "+Count);

		
	////////////////////////////////////////////////	
		
	char[] chh = str.toCharArray();

	int Count1 = 0;
	for (int i = 0; i < chh.length; i++) {
		if (targetchar == chh[i]) {

			Count1++;
		}
	}
	System.out.println("number of occureneces of given charachter using chararray :- " + Count1);

		
		
		
	}

}
