package StringProblems;

import java.util.Scanner;

public class String1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your String value");
		String input = sc.nextLine();
		
		String reverStrig = gerReveserString(input);
		System.out.println(reverStrig);
		
		String[] eachWord = input.split(" ");
		String outputword = " ";
		for(int j = 0; j<eachWord.length; j++)
		{
			if(j%2 == 0)
			{
				outputword += eachWord[j].toUpperCase();
			}
			else {
				outputword += gerReveserString(eachWord[j]);
			}
			if(j!= eachWord.length-1)
			{
				outputword +=" ";
			}
		}
		System.out.println("Changing even index words to UpperCase and odd index to make reverse:"+outputword);
		Character ch = sc.next().charAt(0);
		
		System.out.println("Number of occurences:- "+findNumberOfOccurence(input, ch));
		
	}
	
	 private static String gerReveserString(String input) {
		   
		   String revString = " ";
		   for(int i = input.length()-1; i>=0; i--) {
			   revString += input.charAt(i);
		   }
		   return revString;
	   }
	 
	 private static int findNumberOfOccurence(String input, char character)
	 {
		 int Count = 0;
		 for(int i = 0; i<=input.length()-1;i++)
		 {
			 if(character == input.charAt(i))
			 {
				 Count++;
			 }
		 }
		 
		 return Count;
	 }
 
}
