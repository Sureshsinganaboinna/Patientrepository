package Pro;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Practice {

	public static void main(String[] args) {
		// Find sum of all digits of a number in Java 8?
		int i = 15623;
		
	int summm=	String.valueOf(i).chars().map(t->Character.getNumericValue(t)).sum();
	System.out.println(summm);
	}

}
