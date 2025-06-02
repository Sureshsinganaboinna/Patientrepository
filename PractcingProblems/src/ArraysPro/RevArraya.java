package ArraysPro;

import java.util.Arrays;

public class RevArraya {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5 };

		int i = 0;
		int j = a.length - 1;

		int temp;

		while (i < j) {
			temp = a[j];
			a[j] = a[i];
			a[i] = temp;

			i++;
			

			j--;

		}
		System.out.println(Arrays.toString(a));

	}

}
