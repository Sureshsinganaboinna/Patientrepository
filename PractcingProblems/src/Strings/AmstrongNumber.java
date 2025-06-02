package Strings;

public class AmstrongNumber {

	public static void main(String[] args) {

		int n = 153;
		int temp = n;
		int numberofdigits = 0;
		int ld;
		int sum = 0;
		while (temp > 0) {
			temp = temp / 10;
			numberofdigits++;
		}
		System.out.println(numberofdigits);
		temp = n;
		while (temp > 0) {
			ld = temp % 10;
			int power = 1;
			for (int i = 1; i <= numberofdigits; i++) {
				power = power * ld;
			}
			System.out.println(power);
			sum = sum + power;
			temp = temp / 10;
		}
		if (sum == n) {
			System.out.println(" n value is amstrong number ");
		} else {
			System.out.println(" n value is not a amstrong number ");
		}
	}
//		
//		int n = 153;
//		int temp = n;
//		int numberofdigits = 0;
//		int sum = 0;
//		while(temp > 0)
//		{
//			temp = temp/10;
//			numberofdigits++;
//		}
//	       temp = n;
//	       int ld = 1;
//	      
//		while(temp > 0)
//		{
//			ld = temp%10;
//			 int power = 1;
//		for(int t = 0; t<numberofdigits; t++)
//		{
//			power = power*ld;
//			
//		}
//		System.out.println(power);
//		sum = sum + power;
//		
//		temp = temp/10;
//		}
//		if (n == sum) {
//			System.out.println(n +" is s amstrong number");
//		}
//		else {
//			System.out.println(n +" is not a amstrong number");
//		}
//	}

}
