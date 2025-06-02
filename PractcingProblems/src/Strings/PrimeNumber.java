package Strings;

public class PrimeNumber {

	public static void main(String[] args) {

		int n = 7;
		int flag = 0;
		if (n == 0 || n == 1) {
			System.out.println(n + " value is not a prime number");
		}
		for (int i = 2; i < n; i++) {

			if (n % i == 0) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println(n + " value is a prime number");
		} else {
			System.out.println(n + "  value is not a prime number");
		}
		
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		int s = 5;
		
		int flagg = 0;
		if(s == 0 && s==1)
		{
			System.out.println(  s+ "value is not a prime number");
		}
		for(int i=2; i<s; i++)
		{
			if(s%i == 0)
			{
				flagg = 1;
				break;
			}
			
		}
		if(flagg==0)
		{
			System.out.println(s+ " is a prime number");
		}
		else {
			System.out.println(s+ " is not a prime number");
		}

	}

}
