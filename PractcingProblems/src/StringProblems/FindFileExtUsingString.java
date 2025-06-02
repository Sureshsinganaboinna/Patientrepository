package StringProblems;

import java.util.Scanner;

public class FindFileExtUsingString {

	public static void main(String[] args) {
	    
	  Scanner scanner = new Scanner(System.in);

	  System.out.println("Enter your input string");
	  String input = scanner.nextLine();
	  String fileExt = input.substring(input.lastIndexOf("d"), input.length());
	  System.out.println("File ext :- "+ fileExt);
	  
	}

}
