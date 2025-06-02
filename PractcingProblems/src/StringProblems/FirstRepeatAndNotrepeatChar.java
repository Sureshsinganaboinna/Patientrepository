package StringProblems;

import java.util.Scanner;

public class FirstRepeatAndNotrepeatChar {

	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("Enter your input string");
		  String input = scanner.nextLine();
		  
		  char firstrepeatcharacter = ' ';
		  char firstnonrepeatcharacter = ' ';
		  
		  for(int i = 0; i<input.length(); i++)
		  {
			  char tempchar = input.charAt(i);
			  if(tempchar!=' ') {
			  if(input.indexOf(tempchar)==input.lastIndexOf(tempchar))
			  {
				  if( firstnonrepeatcharacter == ' ')
				  {
					  firstnonrepeatcharacter = tempchar;
				  } 
			  }
			  else if(firstrepeatcharacter == ' ')
			  {
				  firstrepeatcharacter = tempchar;
			  }
		  if(firstnonrepeatcharacter!=' ' && firstrepeatcharacter!=' ')
		  {
			  break;
		  }
			  }
		  }
		  System.out.println("First repeat charachter: "+firstrepeatcharacter);
		  System.out.println("First non repeat charachter: "+firstnonrepeatcharacter);
		  
		  

	}

}
