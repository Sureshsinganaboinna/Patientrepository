package fifteendaysprogram;

public class FactorialRescursiveMethod {

	public static void main(String[] args) {
		int output = factorial(5);
		System.out.println(output);
	}
	
	public static int factorial( int n)
	{
		if(n<1)
		{
			return 1;
		}
	//	n = n*factorial(n-1);
		return n*factorial(n-1);
	}
}
