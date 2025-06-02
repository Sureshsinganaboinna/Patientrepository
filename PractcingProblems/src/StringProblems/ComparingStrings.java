package StringProblems;

public class ComparingStrings {

	public static void main(String[] args) {

		String s1 = "suresh";
		String s4 = new String("suresh");
		String s5 = new String("suresh");
		System.out.println(s5 == s4);
		String s2 = "suresh";
		System.out.println(s1 == s2);
		s1 = s1 + "yadav";
		System.out.println(s1 == s2);
		String s3 = "sureshyadav";
		System.out.println(s1 == s3);
	}

}
