package StringProblems;

import java.util.Scanner;

public class RemoveSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	❇️ Write a java program to remove all starting and ending spaces from a string
		
		Scanner scanner = new Scanner(System.in);
		//trim() will remove starting and ending spaces
		System.out.println("please enter your string");
		String str = scanner.nextLine();
		System.out.println("input :" + str);
		System.out.println("output :"+ str.trim());
		
		
	}

}
