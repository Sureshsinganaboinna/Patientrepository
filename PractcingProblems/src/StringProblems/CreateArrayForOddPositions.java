package StringProblems;

import java.util.Arrays;
import java.util.Scanner;

public class CreateArrayForOddPositions {

	public static void main(String[] args) {
		//create an array using words at add position in a string
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("Enter your input string");
		  String input = scanner.nextLine();
		  String[] wordS = input.split(" ");
		  System.out.println(wordS);
		  String[] output = new String[wordS.length/2];
		  System.out.println(Arrays.toString(output));
		  int index = 0;
		  for(int i=0; i<wordS.length; i++)
		  {
			  if(i%2==1)
			  {
				output[index] = wordS[i];
				index ++;
			  }
		  }
		  
		  System.out.println("new String array  "+ Arrays.toString(output));
	}

}
