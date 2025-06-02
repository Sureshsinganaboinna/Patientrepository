package StringProblimes;

import java.util.Scanner;

public class ChnageOddToupperEvenTolower {

	public static void main(String[] args) {
		// Write a java program to modify the string in the mentioned pattern
		//Change odd to words to upper case and even to reverse words
		// input = This is a test String output = THIS si A tset STRING
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your string");
		String str = scanner.nextLine();
		String[] stt = str.split(" ");
		String revString = "";
		for (int i = 0; i < stt.length; i++) {
			String word = stt[i];
			if (i % 2 == 1) {
				for (int j = word.length() - 1; j >= 0; j--) {
					revString = revString + word.charAt(j);
				} 
			} else if (i % 2 == 0) {
				revString = revString + word.toUpperCase();
			}

			revString = revString + " ";
		}
		System.out.println(revString);
	}

}
