package Strings;

public class FebonicSeries {

	public static void main(String[] args) {
		int n = 8;
		int firstname = 0;
		int secondname = 1;
		int nextnumber;

		for (int i = 1; i <= n; i++) {
			System.out.print(firstname + " ");
			nextnumber = firstname + secondname;
			firstname = secondname;
			secondname = nextnumber;
		}

	}

}
