package com.example.demo.utils;

import java.util.Random;


public class PasscodeGenerator2 {
	/*private static final String DIGITS = "0123456789";
    private static final Random random = new Random();
    public static String generatePasscode(int length) {
        StringBuilder passcode = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(DIGITS.length());
            passcode.append(DIGITS.charAt(index));
        }
        return passcode.toString();
    }*/
	
	private static final String DIGITS = "0123456789";
    private static final Random random = new Random();
 
    public static String generatePasscode(int length) {
        StringBuilder passcode = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
        	 //  System.out.println("Random "+random);
            int index = random.nextInt(DIGITS.length());
            passcode.append(DIGITS.charAt(index));
           // System.out.println(DIGITS.charAt(index));
        }
        return passcode.toString();
    }
//    
//    public class ResponseData {
//   	
//   	public static String RESULT = "result";
//    	public static String SUCCESS = "success";
//}

}
