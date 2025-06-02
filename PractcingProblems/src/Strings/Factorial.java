package Strings;

public class Factorial {

	public static void main(String[] args) {
		int n = 145;
		int temp = n;
		int ld;
		int sum = 0;
		while (n > 0) {
			ld = n % 10;
			int fact = 1;
			for (int i = 1; i <= ld; i++) {
				fact = fact * i;
			}
			sum = sum + fact;
			n = n / 10;
		}
		System.out.println(sum);
		if (sum == temp) {
			System.out.println(temp + " is strong number");
		} else {
			System.out.println(temp + " is not strong number");
		}
	}

}
