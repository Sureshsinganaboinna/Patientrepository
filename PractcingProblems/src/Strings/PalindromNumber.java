package Strings;


public class PalindromNumber {

	public static void main(String[] args) {
		int n = 252;
		int temp = n;
		int ld;
		int sum = 0;
		while (n > 0) {
			ld = n % 10;
			sum = sum * 10 + ld;
			n = n / 10;
		}
		if (sum == temp) {
			System.out.println(temp + " value is palindrom");
		} else {
			System.out.println(temp + " value is not a palindrom");
		}

	}

}
