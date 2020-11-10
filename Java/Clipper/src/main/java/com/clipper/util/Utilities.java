package com.clipper.util;

import java.security.MessageDigest;

public class Utilities {
	/**
	 * Hashes a password by using a basic MD5 algorithm.
	 * 
	 * @param password the password String to be hashed.
	 * @return a String object representing the hashed password.
	 */
	public static String hashPassword(String password) {
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
}
