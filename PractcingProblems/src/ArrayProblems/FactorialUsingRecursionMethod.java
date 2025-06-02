package ArrayProblems;

public class FactorialUsingRecursionMethod {

	public static void main(String[] args) {
	  int output	= factorial(5);
		System.out.println(output);
      
	}
	
	public static int factorial(int n)
	{
		
		if(n==0)
		{
			return 1;
		}
		//System.out.println(s);
		return n * factorial(n - 1);
		
		
	}

}
