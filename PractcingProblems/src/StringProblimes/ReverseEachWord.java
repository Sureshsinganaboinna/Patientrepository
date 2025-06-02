package StringProblimes;

import java.util.Iterator;
import java.util.Scanner;

public class ReverseEachWord {

	public static void main(String[] args) {
		//  Write a java program to reverse each word of a given string
		// input = java is easy output = avaj si ysae
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your string");
		String str = scanner.nextLine();
		System.out.println("Input :" + str);
		String[] strrarray = str.split(" ");
		String reverWordString = "";
		for (int i = 0; i < strrarray.length; i++) {
			String wordS = strrarray[i];
			String revword = "";
			for (int j = wordS.length() - 1; j >= 0; j--) {
				revword = revword + wordS.charAt(j);
			}

			if (i != strrarray.length - 1)
				reverWordString = reverWordString + revword + " ";
			else {
				reverWordString = reverWordString + revword;
			}
		}
		System.out.println("each words reverse of string :-" + reverWordString);
	}

}
