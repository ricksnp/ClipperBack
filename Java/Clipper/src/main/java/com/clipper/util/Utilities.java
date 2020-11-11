package com.clipper.util;

import java.security.MessageDigest;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;

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
	
	public static String getSaltString() {
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
	
	@SuppressWarnings("unused")
	public static void sendEmail(String to, String password) {
		String sendTo = to; //change accordingly  
	      String from = "rickspnathan@gmail.com";//change accordingly  
	      String host = "smtp.gmail.com";//or IP address  
	      
	      // Get system properties
	        Properties properties = System.getProperties();

	        // Setup mail server
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "465");
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

	        // Get the Session object.// and pass username and password
	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("w@gmail.com", "w");
	            }
	        });

	        // Used to debug SMTP issues
	        session.setDebug(true);

	        try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	            // Set Subject: header field
	            message.setSubject("Clipper Password Reset");

	            // Now set the actual message
	            message.setText("Hi User,\n\n Your password has been reset. \n "
	            					 + "Please login with your new password:  " 
	            					 + password);

	            System.out.println("sending...");
	            // Send message
	            Transport.send(message);
	            System.out.println("Sent message successfully....");
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        } 
	}
}
