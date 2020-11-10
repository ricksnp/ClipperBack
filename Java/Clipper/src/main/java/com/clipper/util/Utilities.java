package com.clipper.util;

import java.security.MessageDigest;
import java.util.Random;

public class Utilities {
	/**
	 * Hashes a password by using a basic MD5 algorithm.
	 * 
	 * @param password the password String to be hashed.
	 * @return a String object representing the hashed password.
	 */
	public String hashPassword(String password) {
		StringBuilder result = new StringBuilder(32);
		
		try {
			MessageDigest hasher = MessageDigest.getInstance("MD5");
			
			// Hashes the string, then builds a new string out of the resulting
			// byte array
			byte[]hashBytes = hasher.digest(password.getBytes());
			for(byte b: hashBytes)
				result.append(String.format("%02x", b));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result.toString();
	}
	
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
