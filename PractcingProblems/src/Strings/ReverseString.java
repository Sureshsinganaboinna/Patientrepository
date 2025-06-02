package Strings;

public class ReverseString {

	public static void main(String[] args) {

		String str = "Suresh";
		String ssString = "";
		String reversestr = new String("");
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			reversestr = ch + reversestr;
		}
		System.out.println(reversestr);

		// =============================================================================

		int j = str.length() - 1;
		int i = 0;
		int flag = 0;
		while (i <= j) {
			if (str.charAt(i) != str.charAt(j)) {
				flag = 1;
				break;
			}
			i++;
			j--;
		}
		if (flag == 0) {
			System.out.println(str + ":-string is a palindrom");

		} else {
			System.out.println(str + ":-string is not a palindrom");
		}

	}

}
