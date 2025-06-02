package com.itc.restclient.utils;

import java.util.UUID;

public class PasscodeGenerator {
	   // Method to generate a numeric passcode of specified length
    public static String generateNumericPasscode(int length) {
        // Ensure the requested length is between 4 and 6
        if (length < 4 || length > 6) {
            throw new IllegalArgumentException("Passcode length must be between 4 and 6.");
        }
        // Generate a UUID and take the first 8 characters (hex digits)
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        // Convert the hex string to a long value
        long number = Long.parseLong(uuid, 16);
        // Convert the long value to a numeric string of desired length
        String passcode = String.format("%0" + length + "d", number % (long) Math.pow(10, length));
        return passcode;
    }

}
