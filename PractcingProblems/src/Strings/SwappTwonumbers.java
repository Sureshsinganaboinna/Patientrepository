package Strings;

public class SwappTwonumbers {

	public static void main(String[] args) {
		int i = 5;
		int j = 7;
		/*
		 * int temp;
		 * 
		 * temp = j; j = i; i = temp;
		 * 
		 * System.out.println(i + ", "+ j);
		 */
///////////////////////////////////////

		i = i + j;
		j = i - j;
		i = i - j;

		System.out.println(i + ", " + j);

	}

}
