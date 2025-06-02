package ArraysPro;

import java.util.Scanner;

public class FindMinLenth {

	public static void main(String[] args) {
		// Find the min length word from an array and print it along with its index

		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter your arra size");
		int arraysize = scanner.nextInt();

		String[] arrr = new String[arraysize];
		System.out.println("please ebter array vakues");

		for (int i = 0; i < arraysize; i++) {
			arrr[i] = scanner.next();
		}
		
		String minlenthword = arrr[0];
		int ind = 0;
		for (int i = 0; i < arrr.length; i++) {
			if (minlenthword.length() > arrr[i].length()) {
				minlenthword = arrr[i];
				ind = i;
			}

		}
		System.out.println("Min lenght word " + minlenthword);
		System.out.println("Min lenght word " + ind);
  
  Scanner sccScanner = new Scanner(System.in);
  int arrsiz = sccScanner.nextInt();
   String[] ssStrings = new String[arrsiz];
   
   for( int i =0; i < arrsiz ; i++)
   {
	   ssStrings[i] = sccScanner.next();
   }
   
   String minlength = ssStrings[0];
   int index = 0;
   
   for(int i = 0; i<arrsiz; i++)
   {
	   if(minlength.length()>ssStrings[i].length())
	   {
		   minlength = ssStrings[i];
		   index = i;
	   }
   }
   System.out.println("min word :"+minlength);
   System.out.println("index :"+index);
  
  
 
}}
